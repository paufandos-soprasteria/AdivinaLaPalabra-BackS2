package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Dictionary;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Letter;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Word;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class WordController {

    private static final Logger logger = LogManager.getLogger(DictionaryController.class);

    @PostMapping("/validatePositions")
    public List<Letter> validatePositions() {
        logger.info("Request to validatePositions");
        Word word = new Word(0, new Dictionary(), new Game());
        return word.getLetters();
    }
    
}
