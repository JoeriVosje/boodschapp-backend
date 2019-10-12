package com.hhs.boodschapp.model.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
public class ShoppingListAddedResponse {
    private String statusMessage;
    private int shoppingListId;
    private Timestamp createdAt;
}
