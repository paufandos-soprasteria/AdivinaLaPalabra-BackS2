package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto;

import lombok.Getter;

@Getter
public class CorrectWordDTO {

    private final String correctWord;

    public CorrectWordDTO(String correctWord) {
        this.correctWord = correctWord;
    }
}
