package com.hhs.boodschapp.controller;

import com.hhs.boodschapp.model.entity.Customer;
import com.hhs.boodschapp.model.entity.response.CustomerResponse;
import com.hhs.boodschapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> findCustomers() {
        return customerService.findCustomers();
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerResponse> addCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult) {
        Customer savedCustomer = customerService.addCustomer(customer, bindingResult);

        CustomerResponse response = new CustomerResponse();
        response.setCustomerId(savedCustomer.getId());
        response.setStatusMessage("Customer is added");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/customers/{customerId}")
    public Customer findCustomer(@PathVariable int customerId){
        return customerService.findCustomer(customerId);
    }


//    @PatchMapping("/customers/{customerId}")
//    public Customer updateCustomer(@PathVariable int customerId, @RequestBody Map<String, String> fields) {
//        // TODO Add validation to Customer.
//        return null;
//    }

    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<CustomerResponse> deleteCustomer(@PathVariable int customerId) {
        customerService.deleteCustomer(customerId);

        CustomerResponse response = new CustomerResponse();
        response.setStatusMessage("Customer is deleted");
        response.setCustomerId(customerId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
