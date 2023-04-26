package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities;

public class Letter {

    public String letter;
    public int status;
    public int position;

    public Letter(String letter, int status, int position) {
        this.letter = letter;
        this.status = status;
        this.position = position;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
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
