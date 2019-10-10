package com.hhs.boodschapp.service;

import com.hhs.boodschapp.model.entity.Product;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product, int shoppingListId, BindingResult bindingResult);
}