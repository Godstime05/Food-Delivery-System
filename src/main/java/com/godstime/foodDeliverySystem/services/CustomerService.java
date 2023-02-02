package com.godstime.foodDeliverySystem.services;

import com.godstime.foodDeliverySystem.dto.request.CustomerRequest;
import com.godstime.foodDeliverySystem.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Long id, CustomerRequest customerRequest, Customer customer);
    void deleteCustomer(Long customerId);
    Customer getCustomerById(Long customerId);
    Customer getCustomerByEmail(String email);
    List<Customer> getAllCustomers();

  //  Optional<Object> updateCustomer(Long id, CustomerRequest customerRequest);
}
