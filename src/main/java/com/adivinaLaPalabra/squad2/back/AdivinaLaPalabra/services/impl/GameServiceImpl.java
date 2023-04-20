package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Dictionary;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.DictionaryRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.GameRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl {
    @Autowired
    public GameRepository gameRepository;
    @Autowired
    public DictionaryRepository dictionaryRepository;

    public int newGame() {
        String datenow = Utils.generateDateNowEspFormat();
        int dictionarySize = getDictionarySize();
        int idWord = Utils.generateRandomNumberInRange(dictionarySize);
        Dictionary dictionaryWord = getDictionaryColumn(idWord);
        Game newGame = new Game(dictionaryWord.getWord(), datenow);
        saveNewGame(newGame);
        System.out.println("Partida número " + newGame.id);
        return newGame.getId();
    }

    private void saveNewGame(Game newGame) {
        gameRepository.save(newGame);
    }

    private int getDictionarySize() {
        return (int) dictionaryRepository.count();
    }

    private Dictionary getDictionaryColumn(int idWord) {
        return dictionaryRepository.getReferenceById(idWord);
    }
}
