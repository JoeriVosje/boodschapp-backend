package com.hhs.boodschapp.controller;

import com.hhs.boodschapp.model.entity.ShoppingList;
import com.hhs.boodschapp.service.ShoppingListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingListController {
    private ShoppingListServiceImpl shoppingListServiceImpl;

    @Autowired
    public ShoppingListController(ShoppingListServiceImpl shoppingListServiceImpl) {
        this.shoppingListServiceImpl = shoppingListServiceImpl;
    }

    @GetMapping("/shoppingLists/{customerId}")
    public List<ShoppingList> getShoppingLists(@PathVariable int customerId) {
        return shoppingListServiceImpl.getShoppingLists(customerId);
    }

    @PostMapping("/shoppingLists/{customerId}")
    public String addShoppingList(@PathVariable int customerId) {
        shoppingListServiceImpl.addShoppingList(customerId);
        return "success";
    }
}
