package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl.DictionaryServiceImpl;

import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class DictionaryController {
    @Autowired
    public DictionaryServiceImpl dictionaryService;

    @GetMapping(path = "/checkIfWordExists/{word}", produces = "application/json")
    JSONObject checkIfWordExists(@PathVariable("word") String word) {
        JSONObject response = new JSONObject();
        response.put("wordExists", dictionaryService.checkIfWordExists(word));
        return response;
    }
}