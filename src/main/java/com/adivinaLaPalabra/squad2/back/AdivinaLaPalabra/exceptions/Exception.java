package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
@ControllerAdvice
public class Exception {

    public Exception(String s) {
    }

    @ExceptionHandler({ SQLException.class, java.lang.Exception.class })
    public ResponseEntity<String> handleDatabaseExceptions(java.lang.Exception e) {
        System.out.println("ERROR - " + e.getMessage());
        return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
