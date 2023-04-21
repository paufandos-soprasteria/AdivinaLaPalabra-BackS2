package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.responses;

public class CheckIfWordExistsResponse {

    private Boolean wordExists;

    public CheckIfWordExistsResponse(Boolean wordExists) {
        this.wordExists = wordExists;
    }

    public Boolean getWordExists() {
        return wordExists;
    }

    public void setWordExists(Boolean wordExists) {
        this.wordExists = wordExists;
    }
    
    
}
