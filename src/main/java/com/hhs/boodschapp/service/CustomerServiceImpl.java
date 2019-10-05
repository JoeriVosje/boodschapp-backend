package com.hhs.boodschapp.service;

import com.hhs.boodschapp.exception.BoodschappErrorException;
import com.hhs.boodschapp.model.entity.Customer;
import com.hhs.boodschapp.model.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
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
    public void updateCustomer(int customerId, Map<String, String> fields) {
        Customer customer = findCustomer(customerId);

        for(String field: fields.keySet()){
            set(customer, field, fields.get(field));
        }

        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        findCustomer(customerId);
        customerRepository.deleteById(customerId);
    }

    private void set(Object object, String fieldName, Object fieldValue) {
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(object, fieldValue);
            } catch (NoSuchFieldException e) {
                throw new BoodschappErrorException("Wrong field name entered.", HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                throw new BoodschappErrorException("Error occured", HttpStatus.BAD_REQUEST);
            }
        }
    }
}
