package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckIfWordExistsDTO {

    private Boolean wordExists;

    public CheckIfWordExistsDTO(Boolean wordExists) {
        this.wordExists = wordExists;
    }

}
