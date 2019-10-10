package com.hhs.boodschapp.service;


import com.hhs.boodschapp.exception.BoodschappErrorException;
import com.hhs.boodschapp.model.entity.Customer;
import com.hhs.boodschapp.model.entity.Product;
import com.hhs.boodschapp.model.entity.ShoppingList;
import com.hhs.boodschapp.model.repository.CustomerRepository;
import com.hhs.boodschapp.model.repository.ProductRepository;
import com.hhs.boodschapp.model.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private ShoppingListService shoppingListService;
    private ShoppingListRepository shoppingListRepository;
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ShoppingListService shoppingListService, ShoppingListRepository shoppingListRepository, ProductRepository productRepository) {
        this.shoppingListService = shoppingListService;
        this.shoppingListRepository = shoppingListRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product, int shoppingListId, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BoodschappErrorException("Please enter valid data", HttpStatus.BAD_REQUEST);
        }

        product.setId(0);
        Product savedProduct = productRepository.save(product);

        ShoppingList shoppingList = shoppingListService.findShoppingList(shoppingListId);
        shoppingList.addProduct(product);
        shoppingListRepository.save(shoppingList);

        return savedProduct;
    }
}
