package com.hhs.boodschapp.model.entity.response;

public class ShoppingListOverviewResponse {
    private int shoppingListId;
    private double totalPrice;

    public ShoppingListOverviewResponse() {
    }

    public ShoppingListOverviewResponse(int shoppingListId, double totalPrice) {
        this.shoppingListId = shoppingListId;
        this.totalPrice = totalPrice;
    }

    public int getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(int shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
