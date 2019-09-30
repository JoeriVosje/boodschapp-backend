package com.hhs.boodschapp.service;

import com.hhs.boodschapp.exception.BoodschappErrorException;
import com.hhs.boodschapp.model.entity.Customer;
import com.hhs.boodschapp.model.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findCustomers() {
        List<Customer> customers = customerRepository.findAll();
        if (customers.isEmpty()) {
            throw new BoodschappErrorException("No customers found.", HttpStatus.NOT_FOUND);
        }
        return customers;
    }

    @Override
    public Customer addCustomer(Customer customer, BindingResult bindingResult) {
        customer.setId(0);
        customer.setLastActivity(new Timestamp(System.currentTimeMillis()));
        if (bindingResult.hasErrors()) {
            throw new BoodschappErrorException("Please enter valid data", HttpStatus.BAD_REQUEST);
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer findCustomer(int customerId) {
        Optional<Customer> result = customerRepository.findById(customerId);
        if (!result.isPresent()) {
            throw new BoodschappErrorException("Cannot find customer with id: " + customerId, HttpStatus.NOT_FOUND);
        }
        return result.get();
    }

    @Override
    public void deleteCustomer(int customerId) {
        Optional<Customer> result = customerRepository.findById(customerId);
        if (!result.isPresent()) {
            throw new BoodschappErrorException("Cannot find customer with id: " + customerId, HttpStatus.NOT_FOUND);
        }
        customerRepository.deleteById(customerId);
    }
}
