package com.hhs.boodschapp.model.entity.response;

public class ProductResponse {
    private String statusMessage;
    private int productId;

    public ProductResponse() {
    }

    public ProductResponse(String statusMessage, int productId) {
        this.statusMessage = statusMessage;
        this.productId = productId;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}

