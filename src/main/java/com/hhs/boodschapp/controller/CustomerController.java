package com.hhs.boodschapp.controller;

import com.hhs.boodschapp.model.entity.Customer;
import com.hhs.boodschapp.model.entity.response.CustomerResponse;
import com.hhs.boodschapp.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("customers")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping
    public List<Customer> findCustomers() {
        return customerService.findCustomers();
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> addCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult) {
        Customer savedCustomer = customerService.addCustomer(customer, bindingResult);

        CustomerResponse response = new CustomerResponse("Customer is added", savedCustomer.getId());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{customerId}")
    public Customer findCustomer(@PathVariable int customerId){
        return customerService.findCustomer(customerId);
    }


    @PatchMapping("{customerId}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable int customerId, @RequestBody Map<String, String> fields) {
        customerService.updateCustomer(customerId, fields);

        CustomerResponse response = new CustomerResponse("Customer is updated", customerId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{customerId}")
    public ResponseEntity<CustomerResponse> deleteCustomer(@PathVariable int customerId) {
        customerService.deleteCustomer(customerId);

        CustomerResponse response = new CustomerResponse("Customer is deleted", customerId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
