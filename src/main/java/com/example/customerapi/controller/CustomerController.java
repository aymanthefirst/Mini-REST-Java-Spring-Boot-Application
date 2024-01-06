package com.example.customerapi.controller;

import com.example.customerapi.model.Customer;
import com.example.customerapi.service.CustomerService;
import com.example.customerapi.util.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * CustomerController class to handle file upload and processing.
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CsvReader csvReader;

    /**
     * Endpoint to upload a CSV file and save its data to the database.
     *
     * @param file the CSV file to be uploaded
     * @return ResponseEntity indicating the result of the operation
     */
    @PostMapping("/upload-csv")
    public ResponseEntity<String> uploadCSVFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("Please select a CSV file to upload.", HttpStatus.BAD_REQUEST);
        }

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            List<Customer> customers = csvReader.parseCsvFile(fileReader);
            customerService.saveAllCustomers(customers);
            return new ResponseEntity<>("File uploaded and data saved successfully!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
