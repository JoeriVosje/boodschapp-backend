package com.hhs.boodschapp.service;

import com.hhs.boodschapp.model.entity.Customer;
import com.hhs.boodschapp.model.entity.ShoppingList;
import com.hhs.boodschapp.model.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class ShoppingListService {
    private CustomerRepository customerRepository;

    @Autowired
    public ShoppingListService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addShoppingList(int customerId) {
        Optional<Customer> result = customerRepository.findById(customerId);

        if(!result.isPresent()) {
            throw new RuntimeException("Customer not found");
        }

        Customer customer = result.get();
        ShoppingList shoppingList = new ShoppingList(new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        customer.addShoppingList(shoppingList);
        customerRepository.save(customer);
    }
}
