package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Word;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.WordRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.GameRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.IGameService;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities.DateUtils;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities.NumberUtils;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements IGameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private WordRepository wordRepository;

    @Override
    public Game newGame() {
        LocalDate datenow = DateUtils.generateLocalDateNow();
        int dictionarySize = getDictionarySize();
        int wordId = NumberUtils.generateRandomNumberInRange(dictionarySize);
        Word word = getWord(wordId);
        
        return saveNewGame(new Game(word, datenow));
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
}
