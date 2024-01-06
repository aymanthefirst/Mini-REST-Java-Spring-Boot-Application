package com.example.customerapi.util;

import com.example.customerapi.model.Customer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public List<Customer> parseCsvFile(Reader reader) throws Exception {
        List<Customer> customers = new ArrayList<>();
        try (CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            for (CSVRecord record : csvParser) {
                Customer customer = new Customer(
                        record.get("Customer Ref"),
                        record.get("Customer Name"),
                        record.get("Address Line 1"),
                        record.get("Address Line 2"),
                        record.get("Town"),
                        record.get("County"),
                        record.get("Country"),
                        record.get("Postcode")
                );
                customers.add(customer);
            }
        }
        return customers;
    }
}
