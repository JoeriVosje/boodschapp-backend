package com.hhs.boodschapp.service;

import com.hhs.boodschapp.model.entity.Customer;
import com.hhs.boodschapp.model.entity.Product;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

public interface ProductService {
    Product addProduct(Product product, int shoppingListId, BindingResult bindingResult);
    void updateProduct(int productId, Map<String, String> fields);
    Product findProduct(int productId);
    void deleteProduct(int productId);
}