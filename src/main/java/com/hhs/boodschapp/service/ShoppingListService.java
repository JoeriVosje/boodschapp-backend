package com.hhs.boodschapp.service;

import com.hhs.boodschapp.model.entity.Product;
import com.hhs.boodschapp.model.entity.ShoppingList;

import java.util.List;

public interface ShoppingListService {
    List<ShoppingList> getShoppingLists(int customerId);
    ShoppingList addShoppingList(int customerId);
    void deleteShoppingList(int shoppingListId);
    ShoppingList findShoppingList(int shoppingListId);
}
