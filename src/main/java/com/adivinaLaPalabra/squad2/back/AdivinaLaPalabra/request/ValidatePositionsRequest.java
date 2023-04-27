package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.request;

public class ValidatePositionsRequest {

    private char pos0, pos1, pos2, pos3, pos4;

    public ValidatePositionsRequest(char pos0, char pos1, char pos2, char pos3, char pos4) {
        this.pos0 = pos0;
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.pos3 = pos3;
        this.pos4 = pos4;
    }

    public char getPos0() {
        return pos0;
    }

    public void setPos0(char pos0) {
        this.pos0 = pos0;
    }

    public char getPos1() {
        return pos1;
    }

    public void setPos1(char pos1) {
        this.pos1 = pos1;
    }

    public char getPos2() {
        return pos2;
    }

    public void setPos2(char pos2) {
        this.pos2 = pos2;
    }

    public char getPos3() {
        return pos3;
    }

    public void setPos3(char pos3) {
        this.pos3 = pos3;
    }

    public char getPos4() {
        return pos4;
    }

    public void setPos4(char pos4) {
        this.pos4 = pos4;
    }

    public String wordSerialize() {
        StringBuilder word = new StringBuilder();
        char[] letters = { this.getPos0(), this.getPos1(), this.getPos2(), this.getPos3(), this.getPos4() };

        return word.append(letters).toString().toLowerCase();
    }

}
