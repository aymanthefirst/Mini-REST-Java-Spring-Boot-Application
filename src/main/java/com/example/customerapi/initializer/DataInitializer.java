package com.example.customerapi.initializer;

import com.example.customerapi.model.Customer;
import com.example.customerapi.service.CustomerService;
import com.example.customerapi.util.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

/**
 * DataInitializer class for loading initial data from CSV into the database.
 */
@Component
public class DataInitializer {

    private static final String CSV_PATH = "src/main/resources/customers.csv";

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CsvReader csvReader;

    /**
     * Load CSV data into the database after bean initialization.
     */
    @PostConstruct
    public void init() {
        CsvReader csvReader = new CsvReader();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(CSV_PATH))) {
            List<Customer> customers = csvReader.parseCsvFile(fileReader);
            customerService.saveAllCustomers(customers);
            System.out.println("CSV data loaded into the database.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
