package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services;

import java.util.List;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.LetterDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions.BadRequestException;

public interface IWordService {

    Boolean checkIfWordExists(String word);

    List<LetterDTO> validatePositions(String requestWord, int gameId) throws BadRequestException;

}
