package com.hhs.boodschapp.service;

import com.hhs.boodschapp.model.entity.ShoppingList;

import java.util.List;

public interface ShoppingListService {
    List<ShoppingList> getShoppingLists(int customerId);
    void addShoppingList(int customerId);
}
