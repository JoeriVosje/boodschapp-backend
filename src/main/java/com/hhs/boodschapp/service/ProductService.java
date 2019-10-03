package com.hhs.boodschapp.service;

import com.hhs.boodschapp.model.entity.Product;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface ProductService {
    List<Product> findProducts();
    Product addProduct(Product product, BindingResult bindingResult);
    Product findProduct(int productId);
    void deleteProduct(int productId);
}