package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.CheckAttemptsInRangeDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.CorrectWordDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.GameDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.GameHistoryDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Word;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.WordRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.GameRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.IGameService;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameServiceImpl implements IGameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private WordRepository wordRepository;

    @Override
    public Game newGame() {
        int dictionarySize = getDictionarySize();
        int wordId = NumberUtils.generateRandomNumberInRange(dictionarySize);
        Word word = getWord(wordId);
        
        return saveNewGame(new Game(word));
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

    private Game saveNewGame(Game newGame) {
        return gameRepository.save(newGame);
    }

    private int getDictionarySize() {
        return (int) wordRepository.count();
    }

    private Word getWord(int wordId) {
        return wordRepository.getReferenceById(wordId);
    }

    public List<GameHistoryDTO> getLastTenGames() {
        List<Game> games = gameRepository.findAll();
        List<GameHistoryDTO> gamesDTO = new ArrayList<>();
        games.stream().limit(10).sorted(Comparator.comparing(Game::getDate).reversed())
                .forEach(game -> gamesDTO.add(new GameHistoryDTO(game.getDate(),game.isWinned(),game.getAttempts())));
        return gamesDTO;
    }
}
