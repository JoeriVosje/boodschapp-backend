package com.hhs.boodschapp.service;

import com.hhs.boodschapp.model.entity.Customer;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<Customer> findCustomers();
    Customer addCustomer(Customer customer, BindingResult bindingResult);
    Customer findCustomer(int customerId);
    void updateCustomer(int customerId, Map<String, String> fields);
    void deleteCustomer(int customerId);
}
