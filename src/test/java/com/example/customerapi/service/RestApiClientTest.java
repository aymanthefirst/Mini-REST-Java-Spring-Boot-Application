package com.example.customerapi.service;

import com.example.customerapi.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class RestApiClientTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private RestApiClient restApiClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void sendCustomerData() {
        Customer customer = new Customer("Ref", "Name", "Address1", "Address2", "Town", "County", "Country", "Postcode");
        restApiClient.sendCustomerData(customer, "http://api-endpoint.com");

        verify(restTemplate).postForEntity(any(String.class), any(), any(Class.class));
    }
}
