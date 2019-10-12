package com.hhs.boodschapp.model.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ShoppingListOverviewResponse {
    private int shoppingListId;
    private double totalPrice;
}
