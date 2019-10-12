package com.hhs.boodschapp.controller;

import com.hhs.boodschapp.exception.BoodschappErrorException;
import com.hhs.boodschapp.model.entity.Product;
import com.hhs.boodschapp.model.entity.ShoppingList;
import com.hhs.boodschapp.model.entity.response.ShoppingListDeletedResponse;
import com.hhs.boodschapp.model.entity.response.ShoppingListOverviewResponse;
import com.hhs.boodschapp.model.entity.response.ShoppingListAddedResponse;
import com.hhs.boodschapp.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShoppingListController {
    private ShoppingListService shoppingListService;

    @Autowired
    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @GetMapping("customers/{customerId}/shoppingLists")
    public ResponseEntity<List<ShoppingListOverviewResponse>> getShoppingLists(@PathVariable int customerId) {
        List<ShoppingList> shoppingLists = shoppingListService.getShoppingLists(customerId);
        List<ShoppingListOverviewResponse> response = new ArrayList<>();

        for (ShoppingList shoppingList : shoppingLists) {
            ShoppingListOverviewResponse overview = new ShoppingListOverviewResponse();
            overview.setShoppingListId(shoppingList.getId());
            List<Product> products = shoppingList.getProducts();
            double totalPrice = 0;


                for(Product product : products) {

                    totalPrice += product.getProductAmount() * product.getProductPrice();
                }

                overview.setTotalPrice(totalPrice);
                response.add(overview);
            // TENG: Dit is niet nodig want dan gaat het fout bij meerdere boodschappen waarvan er 1 leeg is.
//            else {
//                throw new BoodschappErrorException("No products added to the shopping lists", HttpStatus.NOT_FOUND);
//            }

        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("customers/{customerId}/shoppingLists")
    public ResponseEntity<ShoppingListAddedResponse> addShoppingList(@PathVariable int customerId) {
        ShoppingList shoppingList = shoppingListService.addShoppingList(customerId);

        ShoppingListAddedResponse response = new ShoppingListAddedResponse("Shopping list is added", shoppingList.getId(), shoppingList.getCreatedAt());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("customers/{customerId}/shoppingLists{shoppingListId}")
    public ResponseEntity<ShoppingListDeletedResponse> deleteShoppingList(@PathVariable int shoppingListId) {
        shoppingListService.deleteShoppingList(shoppingListId);

        return new ResponseEntity<>(new ShoppingListDeletedResponse(shoppingListId, "The shopping list is successfully deleted."), HttpStatus.OK);
    }
}
