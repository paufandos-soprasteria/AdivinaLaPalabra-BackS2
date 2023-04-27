package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LetterDTO {
    public enum Status {NOT_MATCHED, MATCHED, CONTAINED}

    private char letter;

    private Status status;

    private int position;

    public LetterDTO(char letter, Status status, int position) {
        this.letter = letter;
        this.status = status;
        this.position = position;
    }

}
