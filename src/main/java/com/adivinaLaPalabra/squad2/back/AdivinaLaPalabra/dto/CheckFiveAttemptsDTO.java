package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckFiveAttemptsDTO {

    private Boolean cantMore;

    public CheckFiveAttemptsDTO(Boolean cantMore) {
        this.cantMore = cantMore;
    }
}
