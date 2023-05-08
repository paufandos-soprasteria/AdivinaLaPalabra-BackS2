package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions.handlers;

import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.ErrorResponseDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions.BadRequestException;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions.GameIsWinnedException;

import jakarta.persistence.EntityNotFoundException;
import org.w3c.dom.ranges.RangeException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({ UsernameNotFoundException.class })
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    private ErrorResponseDTO handleUsernameNotFoundException(UsernameNotFoundException e) {
        e.printStackTrace();
        return new ErrorResponseDTO(HttpStatus.UNAUTHORIZED.value(), "El nombre de usuario, no existe.");
    }

    @ExceptionHandler({ BadCredentialsException.class })
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    private ErrorResponseDTO handleBadCredentialsException(BadCredentialsException e) {
        e.printStackTrace();
        return new ErrorResponseDTO(HttpStatus.UNAUTHORIZED.value(), "El usuario y/o la contraseña no son correctos.");
    }

    @ExceptionHandler({ BadRequestException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ErrorResponseDTO handleBadRequestException(BadRequestException e) {
        e.printStackTrace();
        return new ErrorResponseDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler({ GameIsWinnedException.class })
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    private ErrorResponseDTO handleGameIsWinnedException(GameIsWinnedException e) {
        e.printStackTrace();
        return new ErrorResponseDTO(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage());
    }

    @ExceptionHandler({ HttpMessageNotReadableException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ErrorResponseDTO handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        e.printStackTrace();
        return new ErrorResponseDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @ExceptionHandler({ EntityNotFoundException.class })
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private ErrorResponseDTO handleEntityNotFoundException(EntityNotFoundException e) {
        e.printStackTrace();
        return new ErrorResponseDTO(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Partida no encontrada");
    }

    @ExceptionHandler({ NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ErrorResponseDTO handleNotFoundException(NoHandlerFoundException e) {
        e.printStackTrace();
        return new ErrorResponseDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
    }

    @ExceptionHandler({ RangeException.class })
    @ResponseStatus(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE)
    private ErrorResponseDTO handleRangeException(RangeException e) {
        e.printStackTrace();
        return new ErrorResponseDTO(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE.value(), "Ha pasado el límite de intentos.");
    }


    @ExceptionHandler({ InvalidDataAccessResourceUsageException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private ErrorResponseDTO handleDatabaseExceptions(InvalidDataAccessResourceUsageException e) {
        e.printStackTrace();
        return new ErrorResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "UPS, algo ha ido mal, no podremos saber lo loser que eres...");
    }

}