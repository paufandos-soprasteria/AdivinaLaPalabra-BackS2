package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.CheckAttemptsInRangeDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.CorrectWordDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.GameHistoryDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions.InsufficientGamesException;

import java.util.List;
import java.util.UUID;

public interface IGameService {

    public Game newGame(String userToken);

    public CorrectWordDTO getCorrectWord(UUID gameId);

    public CheckAttemptsInRangeDTO checkFiveAttempts(UUID gameId);

    public List<GameHistoryDTO> getLastTenGames(String userToken);

    public List<GameHistoryDTO> getAllGames(String userToken) throws InsufficientGamesException;
}
