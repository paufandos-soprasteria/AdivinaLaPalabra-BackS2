package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Attempt;
import java.util.UUID;

public interface IAttemptService {

    Attempt returnAttempt();

    Boolean checkFiveAttempts(UUID gameId);

    void saveAttempt(UUID gameId);
}
