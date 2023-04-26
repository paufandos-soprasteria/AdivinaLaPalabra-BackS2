package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl.GameServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class GameController {
    
    private static final Logger logger = LogManager.getLogger(WordController.class);

    @Autowired
    public GameServiceImpl gameService;

    @GetMapping("/newGame")
    public Game newGame() {
        logger.info("Request to newGame - id: {}", gameService.newGame().getId());
        return gameService.newGame();
    }
}
