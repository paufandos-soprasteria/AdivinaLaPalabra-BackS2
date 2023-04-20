package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl.GameServiceImpl;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class GameController {
    @Autowired
    public GameServiceImpl gameService;

    @GetMapping("/newGame")
    public JSONObject newGame() {
        JSONObject response = new JSONObject();
        response.put("game_id", gameService.newGame());
        return response;
    }
}
