package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.CorrectWordDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import java.util.UUID;

public interface IGameService {

    public Game newGame();

    CorrectWordDTO getCorrectWord(UUID gameId);

} 
