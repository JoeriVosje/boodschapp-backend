package com.hhs.boodschapp.controller;

import com.hhs.boodschapp.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingListController {
    private ShoppingListService shoppingListService;

    @Autowired
    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @PostMapping("/shoppingLists/{customerId}")
    public String addShoppingList(@PathVariable int customerId) {
        shoppingListService.addShoppingList(customerId);
        return "success";
    }
}
