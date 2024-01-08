package com.example.customerapi;

import com.example.customerapi.model.Customer;
import com.example.customerapi.repository.CustomerRepository;
import com.example.customerapi.util.CsvReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CsvUploaderTest {

    @Autowired
    private CustomerRepository customerRepository;

    private final CsvReader csvReader = new CsvReader();
    private static final String CSV_FILE_PATH = "src/main/resources/customers.csv";

    @BeforeEach
    public void setUp() throws Exception {
        customerRepository.deleteAll();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            List<Customer> customers = csvReader.parseCsvFile(fileReader);
            customerRepository.saveAll(customers);
        }
    }

    @Test
    public void testCsvDataLoadedIntoDatabase() {
        List<Customer> csvCustomers;
        try (BufferedReader fileReader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            csvCustomers = csvReader.parseCsvFile(fileReader);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read CSV file", e);
        }

        List<Customer> dbCustomers = customerRepository.findAll();

        assertThat(dbCustomers).usingElementComparatorOnFields("customerRef", "customerName", "addressLine1", "addressLine2", "town", "county", "country", "postcode")
                .containsExactlyInAnyOrderElementsOf(csvCustomers);
    }
}
