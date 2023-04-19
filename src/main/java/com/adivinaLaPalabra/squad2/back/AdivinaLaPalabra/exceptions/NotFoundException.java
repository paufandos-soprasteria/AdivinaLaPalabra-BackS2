package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions;

public class NotFoundException extends Exception {
    public int id;

    NotFoundException(int id) {
        super("Entity not found - id: " + id);
        this.id = id;
    }
}
