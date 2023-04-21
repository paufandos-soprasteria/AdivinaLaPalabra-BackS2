package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.responses.ErrorResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({ NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleDNotFoundException(Exception e) {
        e.printStackTrace();
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
    }

    @ExceptionHandler({ Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleDatabaseExceptions(Exception e) {
        e.printStackTrace();
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }
}
