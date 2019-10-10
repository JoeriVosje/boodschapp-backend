package com.hhs.boodschapp.controller;

import com.hhs.boodschapp.model.entity.Customer;
import com.hhs.boodschapp.model.entity.Product;
import com.hhs.boodschapp.model.entity.response.CustomerResponse;
import com.hhs.boodschapp.model.entity.response.ProductResponse;
import com.hhs.boodschapp.service.CustomerService;
import com.hhs.boodschapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products/{shoppingListId}")
    public ResponseEntity<ProductResponse> addProduct(@Valid @RequestBody Product product, @PathVariable int shoppingListId, BindingResult bindingResult) {
        Product savedProduct = productService.addProduct(product, shoppingListId, bindingResult);

        ProductResponse response = new ProductResponse();
        response.setProductId(savedProduct.getId());
        response.setStatusMessage("Product is added");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
