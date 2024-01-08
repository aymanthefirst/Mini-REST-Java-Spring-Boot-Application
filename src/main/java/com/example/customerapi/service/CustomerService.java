package com.example.customerapi.service;

import com.example.customerapi.model.Customer;
import com.example.customerapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * CustomerService class for handling business logic related to Customer entities.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Saves a list of customers to the database.
     *
     * @param customers The list of customers to be saved.
     */
    public void saveAllCustomers(List<Customer> customers) {
        customerRepository.saveAll(customers);
    }

    /**
     * Saves a single customer to the database.
     *
     * @param customer The customer to be saved.
     */
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    /**
     * Finds a customer by their reference.
     *
     * @param customerRef The reference of the customer.
     * @return An Optional containing the customer if found, or empty otherwise.
     */
    public Optional<Customer> findCustomerByRef(String customerRef) {
        return customerRepository.findById(customerRef);
    }

    // Add other business methods as required
}
