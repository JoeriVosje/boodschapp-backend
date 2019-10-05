package com.hhs.boodschapp.model.entity.response;

import java.sql.Timestamp;

public class ShoppingListResponse {
    private String statusMessage;
    private int shoppingListId;
    private Timestamp createdAt;

    public ShoppingListResponse(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public ShoppingListResponse(String statusMessage, int shoppingListId, Timestamp createdAt) {
        this.statusMessage = statusMessage;
        this.shoppingListId = shoppingListId;
        this.createdAt = createdAt;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public int getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(int shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
