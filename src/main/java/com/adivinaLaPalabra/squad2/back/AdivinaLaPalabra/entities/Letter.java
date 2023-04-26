package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities;

public class Letter {

    public char letter;
    public int status;
    public int position;

    public Letter(char letter, int status, int position) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
