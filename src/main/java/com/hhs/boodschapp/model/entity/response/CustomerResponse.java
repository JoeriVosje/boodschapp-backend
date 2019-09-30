package com.hhs.boodschapp.model.entity.response;

public class CustomerResponse {
    private String statusMessage;
    private int customerId;

    public CustomerResponse() {
    }

    public CustomerResponse(String statusMessage, int customerId) {
        this.statusMessage = statusMessage;
        this.customerId = customerId;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
