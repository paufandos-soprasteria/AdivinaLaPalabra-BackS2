package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.CheckIfWordExistsDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.LetterDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions.BadRequestException;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.request.ValidatePositionsRequest;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl.WordServiceImpl;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class WordController {

    private static final Logger logger = LogManager.getLogger(WordController.class);

    @Autowired
    private WordServiceImpl wordService;

    @GetMapping(path = "/checkIfWordExists/{word}")
    CheckIfWordExistsDTO checkIfWordExists(@PathVariable("word") String word) {
        logger.info("Request to checkIfWordExists - {}", word);
        return new CheckIfWordExistsDTO(wordService.checkIfWordExists(word));
    }

    @PostMapping("/validatePositions/{game_id}")
    public List<LetterDTO> validatePositions(@RequestBody ValidatePositionsRequest body, @PathVariable("game_id") int gameId) throws BadRequestException {
        logger.info("Request to validatePositions - game_id: {}", gameId);
        if (body == null) {
            throw new BadRequestException();
        }
        return wordService.validatePositions(body.wordSerialize(), gameId);
    }
}