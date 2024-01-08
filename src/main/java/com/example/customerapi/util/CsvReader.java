package com.example.customerapi.util;

import com.example.customerapi.model.Customer;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * CsvReader class for parsing CSV files into Customer objects.
 */
@Component
public class CsvReader {

    /**
     * Parses a CSV file from a BufferedReader and returns a list of Customer objects.
     *
     * @param reader The BufferedReader for the CSV file.
     * @return A list of Customer objects.
     * @throws IOException If an I/O error occurs.
     */
    public List<Customer> parseCsvFile(BufferedReader reader) throws IOException {
        List<Customer> customers = new ArrayList<>();
        String line;
        boolean headerProcessed = false;

        while ((line = reader.readLine()) != null) {
            if (!headerProcessed) {
                // Skip the header line
                headerProcessed = true;
                continue;
            }
            String[] data = line.split(",");
            Customer customer = parseCustomerData(data);
            customers.add(customer);
        }

        return customers;
    }

    /**
     * Converts an array of strings (CSV row) into a Customer object.
     *
     * @param data The array of strings representing a row in the CSV.
     * @return A Customer object.
     */
    private Customer parseCustomerData(String[] data) {
        Customer customer = new Customer();
        customer.setCustomerRef(data[0]);
        customer.setCustomerName(data[1]);
        customer.setAddressLine1(data[2]);
        customer.setAddressLine2(data[3]);
        customer.setTown(data[4]);
        customer.setCounty(data[5]);
        customer.setCountry(data[6]);
        customer.setPostcode(data[7]);
        return customer;
    }
}
