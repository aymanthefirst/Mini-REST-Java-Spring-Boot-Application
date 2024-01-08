package com.example.customerapi.controller;

import com.example.customerapi.model.Customer;
import com.example.customerapi.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.*;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @Test
    public void getCustomerByRefTest() {
        String ref = "Cust100";
        Customer mockCustomer = new Customer(ref, "New Customer", "100 Main St", "", "Townsville", "County", "Country", "10000");
        when(customerService.findCustomerByRef(ref)).thenReturn(mockCustomer);

        ResponseEntity<Customer> response = customerController.getCustomerByRef(ref);

        assertEquals(OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(ref, response.getBody().getCustomerRef());
    }
}
