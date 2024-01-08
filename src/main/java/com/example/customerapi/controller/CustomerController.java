package com.example.customerapi.controller;

import com.example.customerapi.model.Customer;
import com.example.customerapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * CustomerController class to handle HTTP requests for customer operations.
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * GET endpoint to retrieve a customer by their reference.
     *
     * @param customerRef The reference of the customer.
     * @return The customer details or an appropriate response if not found.
     */
    @GetMapping("/{customerRef}")
    public ResponseEntity<Customer> getCustomerByRef(@PathVariable String customerRef) {
        return customerService.findCustomerByRef(customerRef)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * POST endpoint to add a new customer.
     *
     * @param customer The customer to be added.
     * @return The added customer.
     */
    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return ResponseEntity.ok(customer);
    }

    // Add other endpoints as required
}
