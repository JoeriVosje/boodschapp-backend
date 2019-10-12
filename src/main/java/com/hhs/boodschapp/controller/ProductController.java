package com.hhs.boodschapp.controller;

import com.hhs.boodschapp.model.entity.Product;
import com.hhs.boodschapp.model.entity.response.ProductResponse;
import com.hhs.boodschapp.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @PostMapping("{shoppingListId}")
    public ResponseEntity<ProductResponse> addProduct(@Valid @RequestBody Product product, @PathVariable int shoppingListId, BindingResult bindingResult) {
        Product savedProduct = productService.addProduct(product, shoppingListId, bindingResult);

        ProductResponse response = new ProductResponse("Product is added", savedProduct.getId());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("{productId}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable int productId, @RequestBody Map<String, String> fields) {
        productService.updateProduct(productId, fields);

        ProductResponse response = new ProductResponse("Product is updated", productId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<ProductResponse> deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);

        ProductResponse response = new ProductResponse("Product is deleted", productId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
