package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto;

import lombok.Getter;

@Getter
public class CheckAttemptsInRangeDTO {

    private final Boolean canMoreAttempts;

    public CheckAttemptsInRangeDTO(Boolean canMoreAttempts) {
        this.canMoreAttempts = canMoreAttempts;
    }
}
