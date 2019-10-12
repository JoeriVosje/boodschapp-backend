package com.hhs.boodschapp.service;

import com.hhs.boodschapp.exception.BoodschappErrorException;
import com.hhs.boodschapp.model.entity.Customer;
import com.hhs.boodschapp.model.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.hhs.boodschapp.service.PatchMappingService.set;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;

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
            PatchMappingService.set(customer, field, fields.get(field));
        }

        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        findCustomer(customerId);
        customerRepository.deleteById(customerId);
    }
}
