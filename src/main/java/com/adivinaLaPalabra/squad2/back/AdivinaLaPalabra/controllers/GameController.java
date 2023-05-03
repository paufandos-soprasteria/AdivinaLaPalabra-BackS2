package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.CheckAttemptsInRangeDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.CorrectWordDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.ErrorResponseDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.GameDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl.GameServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class GameController {
    
    private static final Logger logger = LogManager.getLogger(WordController.class);

    @Autowired
    private GameServiceImpl gameService;

    @ExceptionHandler({ Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private ErrorResponseDTO handleDatabaseExceptions(Exception e) {
        e.printStackTrace();
        return new ErrorResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ha habido un fallo al generar la partida, ya se ve lo loser que eres. Recarga anda.");
    }

    @GetMapping("/newGame")
    private GameDTO newGame() {
        logger.info("Request to newGame");
        return new GameDTO(gameService.newGame().getId());
    }

    @GetMapping("/getCorrectWord/{game_id}")
    private CorrectWordDTO getCorrectWord(@PathVariable("game_id") UUID gameId) {
        logger.info("Request to newGame GameId : "+ gameId);
        return gameService.getCorrectWord(gameId);
    }

    @GetMapping("/checkFiveAttempts/{game_id}")
    private CheckAttemptsInRangeDTO checkFiveAttempts(@PathVariable("game_id") UUID gameId) {
        logger.info("Request to checkFiveAttempts GameId : "+ gameId);
        return gameService.checkFiveAttempts(gameId);
    }
}
