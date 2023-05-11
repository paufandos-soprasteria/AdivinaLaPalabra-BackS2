package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.*;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions.InsufficientGamesException;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl.GameServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class GameController {

    @Autowired
    private GameServiceImpl gameService;

    @ExceptionHandler({ InvalidDataAccessResourceUsageException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private ErrorResponseDTO handleDatabaseExceptions(InvalidDataAccessResourceUsageException e) {
        e.printStackTrace();
        return new ErrorResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ha habido un fallo al generar la partida, ya se ve lo loser que eres. Recarga anda.");
    }

    @GetMapping("/newGame")
    private GameDTO newGame(@RequestHeader (name="Authorization") String token) {
        log.info("Request to newGame");
        return new GameDTO(gameService.newGame(token).getId());
    }

    @GetMapping("/getCorrectWord/{game_id}")
    private CorrectWordDTO getCorrectWord(@PathVariable("game_id") UUID gameId) {
        log.info("Request to getCorrectWord GameId : "+ gameId);
        return gameService.getCorrectWord(gameId);
    }

    @GetMapping("/getLastTenGames")
    private List<GameHistoryDTO> getLastTenGames(@RequestHeader (name="Authorization") String token) throws InsufficientGamesException {
        log.info("Request to getLastTenGames");
        return gameService.getLastTenGames(token);
    }

    @GetMapping("/getTopThreeGames")
    private List<GameHistoryDTO> getTopThreeGames(@RequestHeader (name="Authorization") String token) throws InsufficientGamesException {
        log.info("Request to getTopThreeGames");
        return gameService.getTopThreeGames(token);
    }

    @GetMapping("/checkAttemptsInRange/{game_id}")
    private CheckAttemptsInRangeDTO checkAttemptsInRange(@PathVariable("game_id") UUID gameId) {
        log.info("Request to checkAttemptsInRange GameId : "+ gameId);
        return gameService.checkFiveAttempts(gameId);
    }

    @GetMapping("/getAllGames")
    private List<GameHistoryDTO> getAllGames(@RequestHeader (name="Authorization") String token) throws InsufficientGamesException {
        log.info("Request to getAllGames");
        return gameService.getAllGames(token);
    }
}
