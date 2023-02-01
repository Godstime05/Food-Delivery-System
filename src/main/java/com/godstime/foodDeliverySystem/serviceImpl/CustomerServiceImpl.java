package com.godstime.foodDeliverySystem.serviceImpl;

import com.godstime.foodDeliverySystem.models.Customer;
import com.godstime.foodDeliverySystem.repositories.CustomerRepository;
import com.godstime.foodDeliverySystem.services.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        if (customer.getFirstName() == null || customer.getLastName() == null) {
            throw new IllegalArgumentException("First name and last name are required fields");
        }
        if (customer.getEmail() == null) {
            throw new IllegalArgumentException("Email is a required field");
        }
//        if (customer.getPhoneNo() == null) {
//            throw new IllegalArgumentException("Phone is a required field");
//        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        if (customer.getId() == null) {
            throw new IllegalArgumentException("Customer id is a required field");
        }
        if (customer.getFirstName() == null || customer.getLastName() == null) {
            throw new IllegalArgumentException("First name and last name are required fields");
        }
        if (customer.getEmail() == null) {
            throw new IllegalArgumentException("Email is a required field");
        }
//        if (customer.getPhoneNo() == null) {
//            throw new IllegalArgumentException("Phone is a required field");
//        }
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        if (customerId == null) {
            throw new IllegalArgumentException("Customer id cannot be null");
        }
        if (!customerRepository.existsById(customerId)) {
            throw new EntityNotFoundException("Customer with id " + customerId + " not found");
        }
        customerRepository.deleteById(customerId);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        if (customerId == null) {
            throw new IllegalArgumentException("Customer id cannot be null");
        }
        return customerRepository.findById(customerId).orElseThrow(() ->
                new EntityNotFoundException("Customer with id " + customerId + " not found"));
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        Optional<Customer> customer = Optional.ofNullable(customerRepository.findByEmail(email));
        if (!customer.isPresent()) {
            throw new EntityNotFoundException("Customer with email " + email + " not found");
        }
        return customer.get();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
