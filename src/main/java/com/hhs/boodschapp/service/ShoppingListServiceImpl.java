package com.hhs.boodschapp.service;

import com.hhs.boodschapp.exception.BoodschappErrorException;
import com.hhs.boodschapp.model.entity.Customer;
import com.hhs.boodschapp.model.entity.ShoppingList;
import com.hhs.boodschapp.model.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingListServiceImpl implements ShoppingListService {
    private CustomerRepository customerRepository;

    @Autowired
    public ShoppingListServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<ShoppingList> getShoppingLists(int customerId) {
        Optional<Customer> result = customerRepository.findById(customerId);

        if(!result.isPresent()) {
            throw new BoodschappErrorException("Cannot find customer with id: " + customerId, HttpStatus.NOT_FOUND);
        }

        Customer customer = result.get();
        List<ShoppingList> shoppingLists = customer.getShoppingLists();

        if (shoppingLists.isEmpty()) {
            throw new BoodschappErrorException("No shopping lists were found for this customer", HttpStatus.NOT_FOUND);
        }

        return shoppingLists;
    }

    @Override
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
