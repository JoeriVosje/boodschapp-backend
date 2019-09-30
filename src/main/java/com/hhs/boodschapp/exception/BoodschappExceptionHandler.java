package com.hhs.boodschapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BoodschappExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<BoodschappErrorResponse> handleException(HttpMessageNotReadableException exc) {
        return new ResponseEntity<>(new BoodschappErrorResponse("Please enter a valid JSON."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<BoodschappErrorResponse> handleException(BoodschappErrorException exc) {
        return new ResponseEntity<>(new BoodschappErrorResponse(exc.getMessage()), exc.getStatus());
    }
}
