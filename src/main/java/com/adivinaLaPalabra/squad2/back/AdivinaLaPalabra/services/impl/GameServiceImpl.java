package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Dictionary;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.DictionaryRepository;
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
    public GameRepository gameRepository;

    @Autowired
    public DictionaryRepository dictionaryRepository;

    @Override
    public int newGame() {
        LocalDate datenow = DateUtils.generateLocalDateNow();
        int dictionarySize = getDictionarySize();
        int idWord = NumberUtils.generateRandomNumberInRange(dictionarySize);

        Dictionary dictionaryWord = getDictionaryWord(idWord);
        Game newGame = new Game(dictionaryWord, datenow);
        saveNewGame(newGame);

        return newGame.getId();
    }

    private void saveNewGame(Game newGame) {
        gameRepository.save(newGame);
    }

    private int getDictionarySize() {
        return (int) dictionaryRepository.count();
    }

    private Dictionary getDictionaryWord(int idWord) {
        return dictionaryRepository.getReferenceById(idWord);
    }
}
