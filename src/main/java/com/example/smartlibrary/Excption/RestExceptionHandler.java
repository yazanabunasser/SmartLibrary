package com.example.smartlibrary.Excption;

import javassist.bytecode.DuplicateMemberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

    // Handling not found exceptions
    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException exception){
        ApiError apiError = new ApiError(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                exception
        );
        apiError.setMessage(exception.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    // Handling duplicate entity exception
    @ExceptionHandler(DuplicateMemberException.class)
    protected ResponseEntity<Object> handleDuplicateMemberException(DuplicateMemberException exception){
        ApiError apiError = new ApiError(
                HttpStatus.CONFLICT.value(),
                exception.getMessage(),
                exception
        );
        apiError.setMessage(exception.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }
}
