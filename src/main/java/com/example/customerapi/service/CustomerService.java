package com.example.customerapi.service;

import com.example.customerapi.model.Customer;
import com.example.customerapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * @param customers the list of customers to be saved
     */
    public void saveAllCustomers(List<Customer> customers) {
        customerRepository.saveAll(customers);
    }


}
