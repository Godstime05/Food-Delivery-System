package com.godstime.foodDeliverySystem.services;

import com.godstime.foodDeliverySystem.models.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Long customerId);
    Customer getCustomerById(Long customerId);
    Customer getCustomerByEmail(String email);
    List<Customer> getAllCustomers();
}
