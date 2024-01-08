package com.example.customerapi.service;

import com.example.customerapi.model.Customer;
import com.example.customerapi.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testAddCustomer() {
        Customer newCustomer = new Customer("Cust100", "New Customer", "100 Main St", "", "Townsville", "County", "Country", "10000");
        customerService.saveCustomer(newCustomer);

        Customer foundCustomer = customerRepository.findById("Cust100").orElse(null);
        assertThat(foundCustomer).isNotNull();
        assertThat(foundCustomer.getCustomerName()).isEqualTo("New Customer");

    }

    @Test
    public void comfirmCustomersWereAddedFromCSV(){
        Customer foundCustomer = customerRepository.findById("CUST001").orElse(null);
        assertThat(foundCustomer).isNotNull();
        assertThat(foundCustomer.getCustomerName()).isEqualTo("John Doe");

        foundCustomer = customerRepository.findById("CUST002").orElse(null);
        assertThat(foundCustomer).isNotNull();
        assertThat(foundCustomer.getCustomerName()).isEqualTo("Jane Smith");

        foundCustomer = customerRepository.findById("CUST003").orElse(null);
        assertThat(foundCustomer).isNotNull();
        assertThat(foundCustomer.getCustomerName()).isEqualTo("Bob Johnson");
    }

    //    make sure that CUST003 is not jimmy johnson to comfirm above tests are not just passing either way
    @Test
    public void comfirmingThatTestsWork(){
        Customer foundCustomer = customerRepository.findById("CUST003").orElse(null);
        assertThat(foundCustomer).isNotNull();
        assertThat(foundCustomer.getCustomerName()).isNotEqualTo("Jimmy Johnson");
    }


}
