package com.example.customerapi.util;

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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CsvReaderTest {

    private CsvReader csvReader;

    @BeforeEach
    public void setUp() {
        csvReader = new CsvReader();
    }

    @Test
    public void testParseCsvFile_Success() throws IOException {
        String csvData = "Ref,Name,Address1,Address2,Town,County,Country,Postcode\n" +
                "C001,John Doe,123 Street,Apartment,New York,NY,USA,10001\n" +
                "C002,Jane Doe,456 Avenue,Suite,Los Angeles,CA,USA,90001";

        BufferedReader reader = new BufferedReader(new StringReader(csvData));
        List<Customer> customers = csvReader.parseCsvFile(reader);

        assertNotNull(customers, "Parsed customer list should not be null");
        assertEquals(2, customers.size(), "There should be 2 customers in the list");

        Customer firstCustomer = customers.get(0);
        assertEquals("C001", firstCustomer.getCustomerRef());
        assertEquals("John Doe", firstCustomer.getCustomerName());
        // ... other assertions for firstCustomer

        Customer secondCustomer = customers.get(1);
        assertEquals("C002", secondCustomer.getCustomerRef());
        // ... other assertions for secondCustomer
    }

    @Test
    public void testParseCsvFile_EmptyFile() throws IOException {
        String csvData = "Ref,Name,Address1,Address2,Town,County,Country,Postcode\n";

        BufferedReader reader = new BufferedReader(new StringReader(csvData));
        List<Customer> customers = csvReader.parseCsvFile(reader);

        assertTrue(customers.isEmpty(), "Customer list should be empty for an empty CSV file");
    }

    @Test
    public void testParseCsvFile_MalformedFile() {
        String csvData = "Ref,Name,Address1\n" +
                "C001,John Doe,123 Street";

        BufferedReader reader = new BufferedReader(new StringReader(csvData));
        IOException exception = null;

        try {
            csvReader.parseCsvFile(reader);
        } catch (IOException e) {
            exception = e;
        }

        assertNotNull(exception, "An IOException should be thrown for a malformed CSV file");
    }
}
