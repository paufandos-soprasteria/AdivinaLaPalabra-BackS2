package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Attempt;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.AttemptRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.GameRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.IAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class AttemptServiceImpl implements IAttemptService {

    @Autowired
    AttemptRepository attemptRepository;

    @Autowired
    GameRepository gameRepository;


    @Override
    public Attempt returnAttempt() {
        return null;
    }

    @Override
    public Boolean checkFiveAttempts(UUID gameId) {
        List<Attempt> attempts = attemptRepository.findByGameId(gameId);
        return  attempts.size() >= 5;
    }

    @Override
    public void saveAttempt(UUID gameId){
        Game game = gameRepository.getReferenceById(gameId);
        Attempt attempt = new Attempt(game);
        attemptRepository.save(attempt);
    }
}
