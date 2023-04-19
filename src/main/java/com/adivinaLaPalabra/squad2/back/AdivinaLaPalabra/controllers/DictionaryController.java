package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl.DictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class DictionaryController {
    @Autowired
    public DictionaryServiceImpl dictionaryService;

    @GetMapping("/checkIfWordExists/{word}")
    ResponseEntity<?> checkIfWordExists(@PathVariable("word") String word) {
        return new ResponseEntity<Boolean>(dictionaryService.checkIfWordExists(word), HttpStatus.OK);
    }
}