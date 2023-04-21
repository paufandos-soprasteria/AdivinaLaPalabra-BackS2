package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.responses.NewGameResponse;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl.GameServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class GameController {
    private static final Logger logger = LogManager.getLogger(DictionaryController.class);

    @Autowired
    public GameServiceImpl gameService;

    @GetMapping("/newGame")
    public NewGameResponse newGame() {
        logger.info("Request to newGame");
        return new NewGameResponse(gameService.newGame());
    }
}
