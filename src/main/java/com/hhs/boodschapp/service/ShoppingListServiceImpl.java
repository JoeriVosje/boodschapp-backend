package com.hhs.boodschapp.service;

import com.hhs.boodschapp.exception.BoodschappErrorException;
import com.hhs.boodschapp.model.entity.Customer;
import com.hhs.boodschapp.model.entity.ShoppingList;
import com.hhs.boodschapp.model.repository.CustomerRepository;
import com.hhs.boodschapp.model.repository.ShoppingListRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ShoppingListServiceImpl implements ShoppingListService {
    private CustomerRepository customerRepository;
    private CustomerService customerService;
    private ShoppingListRepository shoppingListRepository;

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

    @Override
    public void deleteShoppingList(int shoppingListId) {
        shoppingListRepository.delete(findShoppingList(shoppingListId));
    }

    @Override
    public ShoppingList findShoppingList(int shoppingListId) {
        Optional<ShoppingList> result = shoppingListRepository.findById(shoppingListId);

        if (!result.isPresent()) {
            throw new BoodschappErrorException("The shopping list with id: " + shoppingListId + " is not found.", HttpStatus.NOT_FOUND);
        }

        return result.get();
    }
}
