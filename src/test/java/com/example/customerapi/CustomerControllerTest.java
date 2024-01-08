package com.example.customerapi;

import com.example.customerapi.controller.CustomerController;
import com.example.customerapi.model.Customer;
import com.example.customerapi.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(CustomerController.class)
@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @MockBean
    private CustomerService customerService;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testGetCustomerByRef_Success() throws Exception {
        String customerRef = "C001";
        Customer customer = new Customer("C001", "John Doe", "123 Street", "Apartment", "New York", "NY", "USA", "10001");

        when(customerService.findCustomerByRef(customerRef)).thenReturn(Optional.of(customer));

        mockMvc.perform(get("/customer/{customerRef}", customerRef))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerRef").value(customerRef))
                .andExpect(jsonPath("$.customerName").value("John Doe"));
    }

    @Test
    public void testGetCustomerByRef_NotFound() throws Exception {
        String customerRef = "C003";
        when(customerService.findCustomerByRef(customerRef)).thenReturn(Optional.empty());

        mockMvc.perform(get("/customer/{customerRef}", customerRef))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testAddCustomer() throws Exception {
        Customer newCustomer = new Customer("C002", "Jane Doe", "456 Avenue", "Suite", "Los Angeles", "CA", "USA", "90001");

        mockMvc.perform(post("/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newCustomer)))
                .andExpect(status().isOk());

        verify(customerService, times(1)).saveCustomer(newCustomer);
    }
}
