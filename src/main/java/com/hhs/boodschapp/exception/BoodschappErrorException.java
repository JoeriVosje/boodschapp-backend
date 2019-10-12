package com.hhs.boodschapp.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BoodschappErrorException extends RuntimeException {
    private HttpStatus status;

    public BoodschappErrorException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
