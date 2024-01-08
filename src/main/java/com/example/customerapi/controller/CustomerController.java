package com.example.customerapi.controller;

import com.example.customerapi.model.Customer;
import com.example.customerapi.service.CustomerService;
import com.example.customerapi.util.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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


    /**
     * GET endpoint to retrieve a customer by their reference.
     *
     * @param customerRef The reference of the customer
     * @return The customer details or an appropriate response if not found
     */
    @GetMapping("/customer/{customerRef}")
    public ResponseEntity<Customer> getCustomerByRef(@PathVariable String customerRef) {
        Customer customer = customerService.findCustomerByRef(customerRef);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
