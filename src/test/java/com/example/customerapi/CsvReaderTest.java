package com.example.customerapi;

import com.example.customerapi.model.Customer;
import com.example.customerapi.util.CsvReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CsvReaderTest {

    private CsvReader csvReader;

    @BeforeEach
    public void setUp() {
        csvReader = new CsvReader();
    }

    @Test
    public void testParseCsvFile() throws IOException {
        String csvData = "Ref,Name,Address1,Address2,Town,County,Country,Postcode\n" +
                "C001,John Doe,123 Street,Apartment,New York,NY,USA,10001\n" +
                "C002,Jane Doe,456 Avenue,Suite,Los Angeles,CA,USA,90001\n" +
                "C003,John Smith,789 Boulevard,Unit,Chicago,IL,USA,60007\n";

        BufferedReader reader = new BufferedReader(new StringReader(csvData));

        List<Customer> customers = csvReader.parseCsvFile(reader);

        assertNotNull(customers, "Parsed customer list should not be null");
        assertEquals(3, customers.size(), "There should be 3 customers in the list");

        // Assertions for the first customer
        Customer firstCustomer = customers.get(0);
        assertEquals("C001", firstCustomer.getCustomerRef());

        // Assertions for the second customer
        Customer secondCustomer = customers.get(1);
        assertEquals("C002", secondCustomer.getCustomerRef());
        assertEquals("Jane Doe", secondCustomer.getCustomerName());

        // Assertions for the third customer
        Customer thirdCustomer = customers.get(2);
        assertEquals("C003", thirdCustomer.getCustomerRef());
        assertEquals("789 Boulevard", thirdCustomer.getAddressLine1());
    }
}