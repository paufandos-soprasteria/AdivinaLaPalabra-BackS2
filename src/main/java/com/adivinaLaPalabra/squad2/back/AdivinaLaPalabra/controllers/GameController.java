package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.ErrorResponseDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.GameDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl.GameServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class GameController {

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
        log.info("Request to newGame");
        return new GameDTO(gameService.newGame().getId());
    }
}
