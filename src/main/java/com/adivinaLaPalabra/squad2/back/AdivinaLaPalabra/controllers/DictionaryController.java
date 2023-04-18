package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Dictionary;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl.DictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DictionaryController {
    @Autowired
    public DictionaryServiceImpl dictionaryService;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>(dictionaryService.hello(),HttpStatus.OK);
    }

    @GetMapping("/getDictionary")
    ResponseEntity<List<Dictionary>> getDictionary() {
        return new ResponseEntity(dictionaryService.getDictionary(), HttpStatus.OK);
    }
}
