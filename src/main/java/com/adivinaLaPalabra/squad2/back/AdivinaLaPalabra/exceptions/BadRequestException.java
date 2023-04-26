package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions;

public class BadRequestException extends Exception{
    public static final String DESCRIPTION = "Bad Request";

    public BadRequestException(){
        super(DESCRIPTION);
    }

    public BadRequestException(String detail){
        super(DESCRIPTION + " - " + detail);
    }
}
