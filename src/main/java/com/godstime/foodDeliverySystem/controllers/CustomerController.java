package com.godstime.foodDeliverySystem.controllers;

import com.godstime.foodDeliverySystem.dto.request.CustomerRequest;
import com.godstime.foodDeliverySystem.dto.response.CustomerResponse;
import com.godstime.foodDeliverySystem.exceptions.ResourceNotFoundException;
import com.godstime.foodDeliverySystem.models.Customer;
import com.godstime.foodDeliverySystem.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
              //  .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        CustomerResponse customerResponse = new CustomerResponse(customer.getId(), customer.getFirstName(), customer.getEmail());
        return ResponseEntity.ok(customerResponse);
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody Customer customer, CustomerRequest customerRequest) {
        Customer customer1 = customerService.createCustomer(customer);
        CustomerResponse customerResponse = new CustomerResponse(customer.getId(), customer.getFirstName(), customer.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable Long id,
                                                           @Valid @RequestBody Customer customer, CustomerRequest customerRequest) {
        Customer customer1 = customerService.updateCustomer(id, customerRequest, customer);
              //  .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        CustomerResponse customerResponse = new CustomerResponse(customer.getId(), customer.getFirstName(), customer.getEmail());
        return ResponseEntity.ok(customerResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}