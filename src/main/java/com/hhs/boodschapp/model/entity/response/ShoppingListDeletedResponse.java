package com.hhs.boodschapp.model.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ShoppingListDeletedResponse {
    private  int shoppingListId;
    private String statusMessage;
}
