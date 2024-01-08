package com.example.customerapi.service;

import com.example.customerapi.model.Customer;
import com.example.customerapi.repository.CustomerRepository;
import com.example.customerapi.util.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

/**
 * CustomerService class for handling business logic related to Customer entities.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CsvReader csvReader;

    /**
     * Method to load CSV data and save to the database after the bean initialization.
     */
    @PostConstruct
    public void initDatabaseWithCsvData() {
        String path = "C:/Users/Administrator.Ayman/Downloads/customerapi/customerapi/src/main/resources/customers.csv";
        try (BufferedReader fileReader = new BufferedReader(new FileReader(path))) {
            List<Customer> customers = csvReader.parseCsvFile(fileReader);
            saveAllCustomers(customers);
            System.out.println("CSV data loaded into the database.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves a list of customers to the database.
     *
     * @param customers the list of customers to be saved
     */
    public void saveAllCustomers(List<Customer> customers) {
        customerRepository.saveAll(customers);
    }

    public void saveCustomer(Customer newCustomer) {
        customerRepository.save(newCustomer);
    }

    public Customer findCustomerByRef(String customerRef) {
        return customerRepository.findById(customerRef).orElse(null);
    }
}
