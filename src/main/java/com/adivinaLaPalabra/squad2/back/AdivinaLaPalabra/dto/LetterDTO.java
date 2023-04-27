package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto;

public class LetterDTO {

    final static int NOT_MATCHED_LETTER_STATUS = 0;

    final static int MATCHED_LETTER_STATUS = 1;

    final static int CONTAINED_LETTER_STATUS = 2;

    public enum Status {NOT_MATCHED_LETTER_STATUS, MATCHED_LETTER_STATUS, CONTAINED_LETTER_STATUS}

    public char letter;

    public int status;

    public int position;

    public LetterDTO(char letter, Status status, int position) {
        this.letter = letter;
        this.status = status.ordinal();
        this.position = position;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status.ordinal();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
