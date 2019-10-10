package com.hhs.boodschapp.model.entity.response;

public class ShoppingListDeletedResponse {
    private  int shoppingListId;
    private String statusMessage;

    public ShoppingListDeletedResponse() {
    }

    public ShoppingListDeletedResponse(int shoppingListId, String statusMessage) {
        this.shoppingListId = shoppingListId;
        this.statusMessage = statusMessage;
    }

    public int getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(int shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
