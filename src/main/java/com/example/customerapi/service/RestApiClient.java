package com.example.customerapi.service;

import com.example.customerapi.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

public class RestApiClient {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public RestApiClient() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    public void sendCustomerData(Customer customer, String apiEndpoint) {
        try {
            // Convert Customer object to JSON
            String json = objectMapper.writeValueAsString(customer);

            // Setting headers for the request
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // Create a new HttpEntity
            HttpEntity<String> entity = new HttpEntity<>(json, headers);

            // Send POST request
            ResponseEntity<String> response = restTemplate.postForEntity(apiEndpoint, entity, String.class);

            // Handle response here, if needed
            System.out.println("Response: " + response.getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
