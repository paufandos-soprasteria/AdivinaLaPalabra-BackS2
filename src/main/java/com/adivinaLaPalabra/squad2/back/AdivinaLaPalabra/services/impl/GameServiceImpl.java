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
    private UserServiceImpl userServiceImpl ;

    @Override
    public Game newGame(String username) {
        int dictionarySize = getDictionarySize();
        int wordId = NumberUtils.generateRandomNumberInRange(dictionarySize);

        Word word = getWord(wordId);
        User user = userServiceImpl.getUserByUsername(username);

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
    public List<GameHistoryDTO> getLastTenGames(String username) {
        UUID userId = userServiceImpl.getUserByUsername(username).getId();
        List<Game> games = gameRepository.findTop10ByUser_IdOrderByDateDesc(userId);
        return serializeToDTO(games);
    }

    @Override
    public List<GameHistoryDTO> getTopThreeGames(String username) {
        UUID userId = userServiceImpl.getUserByUsername(username).getId();
        List<Game> games = gameRepository.getTop3UserGames(userId);
        return serializeToDTO(games);
    }

    @Override
    public List<GameHistoryDTO> getAllGames(String username) throws InsufficientGamesException {
        checkIfUserHasEnoughGames(username);
        UUID userId = userServiceImpl.getUserByUsername(username).getId();
        List<Game> games = gameRepository.findAllByUser_Id(userId);
        return serializeToDTO(games);
    }

    private Game saveNewGame(Game newGame) {
        return gameRepository.save(newGame);
    }

    private boolean hasEnoughGames(String username) {
        UUID userId = userServiceImpl.getUserByUsername(username).getId();
        return gameRepository.countByUser_Id(userId) > MAX_GAMES_SIZE;
    }

    public void checkIfUserHasEnoughGames(String username) throws InsufficientGamesException {
        if (!hasEnoughGames(username)) throw new InsufficientGamesException();
    }

    private List<GameHistoryDTO> serializeToDTO(List<Game> games) {
        List<GameHistoryDTO> gamesDTO = new ArrayList<>();
        games.forEach(game -> gamesDTO.add(new GameHistoryDTO(game.getDate(), game.getWinned(), game.getAttempts())));
        return gamesDTO;
    }

    private int getDictionarySize() {
        return (int) wordRepository.count();
    }

    private Word getWord(int wordId) {
        return wordRepository.getReferenceById(wordId);
    }
}
