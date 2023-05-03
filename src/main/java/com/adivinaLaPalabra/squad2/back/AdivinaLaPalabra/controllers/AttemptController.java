package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.CheckFiveAttemptsDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl.AttemptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AttemptController {

    @Autowired
    private AttemptServiceImpl attemptService;

    @GetMapping(path = "/checkFiveAttempts/{game_id}")
    private CheckFiveAttemptsDTO checkFiveAttempts(@PathVariable("game_id") UUID gameId) {
        return new CheckFiveAttemptsDTO(attemptService.checkFiveAttempts(gameId));
    }
}
