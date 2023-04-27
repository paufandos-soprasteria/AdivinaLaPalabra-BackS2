package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions;

import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.ErrorResponseDTO;

import jakarta.persistence.EntityNotFoundException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({ BadRequestException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleBadRequestException(BadRequestException e) {
        e.printStackTrace();
        return new ErrorResponseDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler({ HttpMessageNotReadableException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleBadRequestException(HttpMessageNotReadableException e) {
        e.printStackTrace();
        return new ErrorResponseDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @ExceptionHandler({ EntityNotFoundException.class })
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponseDTO handleEntityNotFoundException(EntityNotFoundException e) {
        e.printStackTrace();
        return new ErrorResponseDTO(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Partida no encontrada");
    }

    @ExceptionHandler({ NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleNotFoundException(NoHandlerFoundException e) {
        e.printStackTrace();
        return new ErrorResponseDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
    }

    @ExceptionHandler({ InvalidDataAccessResourceUsageException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDTO handleDatabaseExceptions(InvalidDataAccessResourceUsageException e) {
        e.printStackTrace();
        return new ErrorResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(),"UPS, algo ha ido mal, no podremos saber lo loser que eres...");
    }

    @ExceptionHandler({ Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDTO handleDatabaseExceptions(Exception e) {
        e.printStackTrace();
        return new ErrorResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ups, algo ha ido mal.");
    }
}
