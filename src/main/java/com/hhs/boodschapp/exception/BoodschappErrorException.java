package com.hhs.boodschapp.exception;

import org.springframework.http.HttpStatus;

public class BoodschappErrorException extends RuntimeException {
    private HttpStatus status;

    public BoodschappErrorException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
