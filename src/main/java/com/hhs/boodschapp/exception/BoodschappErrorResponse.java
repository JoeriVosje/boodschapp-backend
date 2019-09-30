package com.hhs.boodschapp.exception;

public class BoodschappErrorResponse {
    private String statusMessage;

    public BoodschappErrorResponse() {
    }

    public BoodschappErrorResponse(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
