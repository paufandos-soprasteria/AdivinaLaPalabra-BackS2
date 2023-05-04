package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto;

import lombok.Getter;

@Getter
public class CheckIfWordExistsDTO {

    private final Boolean wordExists;

    public CheckIfWordExistsDTO(Boolean wordExists) {
        this.wordExists = wordExists;
    }

}
