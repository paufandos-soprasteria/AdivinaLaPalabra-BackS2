package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.responses.CheckIfWordExistsResponse;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl.DictionaryServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class DictionaryController {

    private static final Logger logger = LogManager.getLogger(DictionaryController.class);

    @Autowired
    public DictionaryServiceImpl dictionaryService;

    @GetMapping(path = "/checkIfWordExists/{word}")
    CheckIfWordExistsResponse checkIfWordExists(@PathVariable("word") String word) {
        logger.info("Request to checkIfWordExists - {}", word);
        return new CheckIfWordExistsResponse(dictionaryService.checkIfWordExists(word));
    }
}