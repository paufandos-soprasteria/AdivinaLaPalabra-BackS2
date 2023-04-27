package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto;

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

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
