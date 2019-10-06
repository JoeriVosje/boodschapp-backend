package com.hhs.boodschapp.controller;

import com.hhs.boodschapp.exception.BoodschappErrorException;
import com.hhs.boodschapp.model.entity.Product;
import com.hhs.boodschapp.model.entity.ShoppingList;
import com.hhs.boodschapp.model.entity.response.ShoppingListOverviewResponse;
import com.hhs.boodschapp.model.entity.response.ShoppingListResponse;
import com.hhs.boodschapp.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShoppingListController {
    private ShoppingListService shoppingListService;

    @Autowired
    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @GetMapping("/shoppingLists/{customerId}")
    public ResponseEntity<List<ShoppingListOverviewResponse>> getShoppingLists(@PathVariable int customerId) {
        List<ShoppingList> shoppingLists = shoppingListService.getShoppingLists(customerId);
        List<ShoppingListOverviewResponse> response = new ArrayList<>();

        for (ShoppingList shoppingList : shoppingLists) {
            List<Product> products = shoppingList.getProducts();
            if (!products.isEmpty()) {
                for(Product product : products) {
                    ShoppingListOverviewResponse overview = new ShoppingListOverviewResponse();
                    overview.setShoppingListId(shoppingList.getId());
                    overview.setTotalPrice(product.getProductAmount() * product.getProductPrice());
                    response.add(overview);
                }
            } else {
                throw new BoodschappErrorException("No products added to the shopping lists", HttpStatus.NOT_FOUND);
            }

        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/shoppingLists/{customerId}")
    public ResponseEntity<ShoppingListResponse> addShoppingList(@PathVariable int customerId) {
        ShoppingList shoppingList = shoppingListService.addShoppingList(customerId);

        ShoppingListResponse response = new ShoppingListResponse("Shopping list is added", shoppingList.getId(), shoppingList.getCreatedAt());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
