package com.hhs.boodschapp.controller;

import com.hhs.boodschapp.model.entity.ShoppingList;
import com.hhs.boodschapp.model.entity.response.ShoppingListResponse;
import com.hhs.boodschapp.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingListController {
    private ShoppingListService shoppingListService;

    @Autowired
    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @GetMapping("/shoppingLists/{customerId}")
    public List<ShoppingList> getShoppingLists(@PathVariable int customerId) {
        return shoppingListService.getShoppingLists(customerId);
    }

    @PostMapping("/shoppingLists/{customerId}")
    public ResponseEntity<ShoppingListResponse> addShoppingList(@PathVariable int customerId) {
        ShoppingList shoppingList = shoppingListService.addShoppingList(customerId);

        ShoppingListResponse response = new ShoppingListResponse("Shopping list is added", shoppingList.getId(), shoppingList.getCreatedAt());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
