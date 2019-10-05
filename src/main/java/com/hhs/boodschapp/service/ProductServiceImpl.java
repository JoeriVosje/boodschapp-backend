package com.hhs.boodschapp.service;


import com.hhs.boodschapp.exception.BoodschappErrorException;
import com.hhs.boodschapp.model.entity.Customer;
import com.hhs.boodschapp.model.entity.Product;
import com.hhs.boodschapp.model.repository.CustomerRepository;
import com.hhs.boodschapp.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new BoodschappErrorException("No products found.", HttpStatus.NOT_FOUND);
        }
        return products;
    }

    @Override
    public Product addProduct(Product product, BindingResult bindingResult) {
        product.setId(0);
        if (bindingResult.hasErrors()) {
            throw new BoodschappErrorException("Please enter valid data", HttpStatus.BAD_REQUEST);
        }
        return productRepository.save(product);
    }

    @Override
    public Product findProduct(int productId) {
        Optional<Product> result = productRepository.findById(productId);
        if (!result.isPresent()) {
            throw new BoodschappErrorException("Cannot find product with id: " + productId, HttpStatus.NOT_FOUND);
        }
        return result.get();
    }

    @Override
    public void deleteProduct(int productId) {
        Optional<Product> result = productRepository.findById(productId);
        if (!result.isPresent()) {
            throw new BoodschappErrorException("Cannot find product with id: " + productId, HttpStatus.NOT_FOUND);
        }
        productRepository.deleteById(productId);

    }
}
