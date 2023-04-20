package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities.Utils;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<JSONObject> handleDNotFoundException() {
        return Utils.errorResponse(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<JSONObject> handleDatabaseExceptions() {
        return Utils.errorResponse(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
