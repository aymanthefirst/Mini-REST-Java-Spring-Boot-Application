package com.example.customerapi.repository;

import com.example.customerapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CustomerRepository interface for CRUD operations on Customer entities.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    // Additional custom methods if required
}
