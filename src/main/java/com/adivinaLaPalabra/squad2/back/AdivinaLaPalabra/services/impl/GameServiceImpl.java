package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.CheckAttemptsInRangeDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.CorrectWordDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.GameHistoryDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Word;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions.InsufficientGamesException;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.User;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.WordRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.security.jwt.JwtUtils;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.GameRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.UserRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.IGameService;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities.NumberUtils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class GameServiceImpl implements IGameService {

    private final int MAX_GAMES_SIZE = 10;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public Game newGame(String userToken) {
        int dictionarySize = getDictionarySize();
        int wordId = NumberUtils.generateRandomNumberInRange(dictionarySize);

        Word word = getWord(wordId);
        User user = getUserFromToken(userToken);

        return saveNewGame(new Game(word, user));
    }

    @Override
    public CorrectWordDTO getCorrectWord(UUID gameId) {
        return new CorrectWordDTO(gameRepository.getReferenceById(gameId).getCorrectWord().getValue());
    }

    @Override
    public CheckAttemptsInRangeDTO checkFiveAttempts(UUID gameId) {
        final int MAX_RANGE = 5;
        Game game = gameRepository.getReferenceById(gameId);
        Boolean canMoreAttempts = game.getAttempts() < MAX_RANGE;
        return new CheckAttemptsInRangeDTO(canMoreAttempts);
    }

    @Override
    public List<GameHistoryDTO> getLastTenGames(String userToken) {
        UUID userId = getUserFromToken(userToken).getId();
        List<Game> games = gameRepository.findTop10ByUser_IdOrderByDateDesc(userId);
        return serializeToDTO(games);
    }

    @Override
    public List<GameHistoryDTO> getAllGames(String userToken) throws InsufficientGamesException {
        UUID userId = getIdIfHasMoreThan10Games(userToken);
        List<Game> games = gameRepository.findAllByUser_Id(userId);
        return serializeToDTO(games);
    }

    private Game saveNewGame(Game newGame) {
        return gameRepository.save(newGame);
    }

    private boolean hasMoreThanTenGames(String userToken) {
        UUID userId = getUserFromToken(userToken).getId();
        return gameRepository.findAllByUser_Id(userId).size() > MAX_GAMES_SIZE;
    }

    private UUID getIdIfHasMoreThan10Games(String userToken) throws InsufficientGamesException {
        if (!hasMoreThanTenGames(userToken))
            throw new InsufficientGamesException();
        return getUserFromToken(userToken).getId();
    }

    private List<GameHistoryDTO> serializeToDTO(List<Game> games) {
        List<GameHistoryDTO> gamesDTO = new ArrayList<>();
        games.forEach(game -> gamesDTO.add(new GameHistoryDTO(game.getDate(), game.isWinned(), game.getAttempts())));
        return gamesDTO;
    }

    private int getDictionarySize() {
        return (int) wordRepository.count();
    }

    private Word getWord(int wordId) {
        return wordRepository.getReferenceById(wordId);
    }

    private User getUserFromToken(String userToken) {
        String username = jwtUtils.getUsernameFromAuthHeader(userToken);
        User user = userRepository.findByName(username);
        if (user == null)
            throw new EntityNotFoundException("No se ha encontrado el usuario con el nombre" + username);
        return user;
    }

}
