package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.ErrorResponseDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.GameDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl.GameServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class GameController {
    
    private static final Logger logger = LogManager.getLogger(WordController.class);

    @ExceptionHandler({ Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDTO handleDatabaseExceptions(Exception e) {
        e.printStackTrace();
        return new ErrorResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ha habido un fallo al generar la partida, ya se ve lo loser que eres. Recarga anda.");
    }

    @Autowired
    public GameServiceImpl gameService;

    @GetMapping("/newGame")
    public GameDTO newGame() {
        logger.info("Request to newGame");
        return gameService.newGame();
    }
}
