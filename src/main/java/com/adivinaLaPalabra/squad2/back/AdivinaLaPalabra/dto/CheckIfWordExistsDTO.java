package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto;

public class CheckIfWordExistsDTO {

    private Boolean wordExists;

    public CheckIfWordExistsDTO(Boolean wordExists) {
        this.wordExists = wordExists;
    }

    public Boolean getWordExists() {
        return wordExists;
    }

    public void setWordExists(Boolean wordExists) {
        this.wordExists = wordExists;
    }
    
    
}
