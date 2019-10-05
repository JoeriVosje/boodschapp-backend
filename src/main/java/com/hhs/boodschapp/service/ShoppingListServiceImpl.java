package com.hhs.boodschapp.service;

import com.hhs.boodschapp.exception.BoodschappErrorException;
import com.hhs.boodschapp.model.entity.Customer;
import com.hhs.boodschapp.model.entity.ShoppingList;
import com.hhs.boodschapp.model.repository.CustomerRepository;
import com.hhs.boodschapp.model.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ShoppingListServiceImpl implements ShoppingListService {
    private CustomerRepository customerRepository;
    private CustomerService customerService;
    private ShoppingListRepository shoppingListRepository;

    @Autowired
    public ShoppingListServiceImpl(CustomerRepository customerRepository, CustomerService customerService, ShoppingListRepository shoppingListRepository) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
        this.shoppingListRepository = shoppingListRepository;
    }

    @Override
    public List<ShoppingList> getShoppingLists(int customerId) {
        Customer customer = customerService.findCustomer(customerId);
        List<ShoppingList> shoppingLists = customer.getShoppingLists();

        if (shoppingLists.isEmpty()) {
            throw new BoodschappErrorException("No shopping lists were found for this customer", HttpStatus.NOT_FOUND);
        }

        return shoppingLists;
    }

    @Override
    public ShoppingList addShoppingList(int customerId) {
        Customer customer = customerService.findCustomer(customerId);
        ShoppingList shoppingList = shoppingListRepository.save(new ShoppingList(new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
        customer.addShoppingList(shoppingList);
        customerRepository.save(customer);

        return shoppingList;
    }
}
