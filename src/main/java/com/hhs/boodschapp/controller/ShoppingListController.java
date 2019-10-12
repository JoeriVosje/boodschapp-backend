package com.hhs.boodschapp.controller;

import com.hhs.boodschapp.model.entity.Product;
import com.hhs.boodschapp.model.entity.ShoppingList;
import com.hhs.boodschapp.model.entity.response.ShoppingListDeletedResponse;
import com.hhs.boodschapp.model.entity.response.ShoppingListOverviewResponse;
import com.hhs.boodschapp.model.entity.response.ShoppingListAddedResponse;
import com.hhs.boodschapp.service.ShoppingListService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("customers")
@AllArgsConstructor
public class ShoppingListController {
    private ShoppingListService shoppingListService;

    @GetMapping("{customerId}/shoppingLists")
    public ResponseEntity<List<ShoppingListOverviewResponse>> getShoppingLists(@PathVariable int customerId) {
        List<ShoppingList> shoppingLists = shoppingListService.getShoppingLists(customerId);
        List<ShoppingListOverviewResponse> response = new ArrayList<>();

        for (ShoppingList shoppingList : shoppingLists) {
            List<Product> products = shoppingList.getProducts();
            double totalPrice = 0;

                for(Product product : products) {
                    totalPrice += product.getProductAmount() * product.getProductPrice();
                }

                ShoppingListOverviewResponse overview = new ShoppingListOverviewResponse(shoppingList.getId(), totalPrice);
                response.add(overview);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("{customerId}/shoppingLists")
    public ResponseEntity<ShoppingListAddedResponse> addShoppingList(@PathVariable int customerId) {
        ShoppingList shoppingList = shoppingListService.addShoppingList(customerId);

        ShoppingListAddedResponse response = new ShoppingListAddedResponse("Shopping list is added", shoppingList.getId(), shoppingList.getCreatedAt());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{customerId}/shoppingLists/{shoppingListId}")
    public ResponseEntity<ShoppingListDeletedResponse> deleteShoppingList(@PathVariable int customerId, @PathVariable int shoppingListId) {
        shoppingListService.deleteShoppingList(shoppingListId);

        return new ResponseEntity<>(new ShoppingListDeletedResponse(shoppingListId, "The shopping list is successfully deleted."), HttpStatus.OK);
    }
}
