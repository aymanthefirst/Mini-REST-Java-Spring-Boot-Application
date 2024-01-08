package com.example.customerapi;

import com.example.customerapi.model.Customer;
import com.example.customerapi.repository.CustomerRepository;
import com.example.customerapi.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveAllCustomers() {
        List<Customer> customers = Arrays.asList(
                new Customer("C001", "John Doe", "123 Street", "Apartment", "New York", "NY", "USA", "10001"),
                new Customer("C002", "Jane Doe", "456 Avenue", "Suite", "Los Angeles", "CA", "USA", "90001")
        );

        customerService.saveAllCustomers(customers);

        verify(customerRepository, times(1)).saveAll(customers);
    }

    @Test
    public void testFindCustomerByRef_ExistingCustomer() {
        String customerRef = "C001";
        Customer customer = new Customer("C001", "John Doe", "123 Street", "Apartment", "New York", "NY", "USA", "10001");

        when(customerRepository.findById(customerRef)).thenReturn(Optional.of(customer));

        Optional<Customer> found = customerService.findCustomerByRef(customerRef);

        assertTrue(found.isPresent(), "Customer should be found");
        assertEquals(customer, found.get(), "Found customer should match the expected");
    }

    @Test
    public void testFindCustomerByRef_NonExistingCustomer() {
        String customerRef = "C003";
        when(customerRepository.findById(customerRef)).thenReturn(Optional.empty());

        Optional<Customer> found = customerService.findCustomerByRef(customerRef);

        assertFalse(found.isPresent(), "Non-existing customer should not be found");
    }
}
