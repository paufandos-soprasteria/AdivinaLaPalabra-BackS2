package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidatePositionsRequest {

    private char pos0, pos1, pos2, pos3, pos4;

    public ValidatePositionsRequest(char pos0, char pos1, char pos2, char pos3, char pos4) {
        this.pos0 = pos0;
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.pos3 = pos3;
        this.pos4 = pos4;
    }

    public String wordSerialize() {
        StringBuilder word = new StringBuilder();
        char[] letters = { this.getPos0(), this.getPos1(), this.getPos2(), this.getPos3(), this.getPos4() };

        return word.append(letters).toString().toLowerCase();
    }

}
