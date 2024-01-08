package com.example.customerapi.console;

import com.example.customerapi.model.Customer;
import com.example.customerapi.util.CsvReader;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

/**
 * CsvUploader console application to read CSV and send data to the REST API.
 */
public class CsvUploader {

    private static final String CSV_FILE_PATH = "C:/Users/Administrator.Ayman/Downloads/customerapi/customerapi/src/main/resources/customers.csv";
    private static final String API_URL = "http://localhost:8080/api/customers";

    public static void main(String[] args) {
        try {
            List<Customer> customers = readCustomersFromCsv();
            postCustomersToApi(customers);
            System.out.println("Customers uploaded successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Customer> readCustomersFromCsv() throws Exception {
        CsvReader csvReader = new CsvReader();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            return csvReader.parseCsvFile(fileReader);
        }
    }

    private static void postCustomersToApi(List<Customer> customers) {
        RestTemplate restTemplate = new RestTemplate();
        customers.forEach(customer -> restTemplate.postForObject(API_URL, customer, Customer.class));
    }
}
