package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InsufficientGamesException extends Exception{

    private static final String DESCRIPTION = "No tiene suficientes partidas";

    public InsufficientGamesException(String detail){
        super(DESCRIPTION + " - " + detail);
    }
}
