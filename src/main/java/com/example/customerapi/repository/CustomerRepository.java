package com.example.customerapi.repository;

import com.example.customerapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CustomerRepository interface extends JpaRepository for CRUD operations and
 * custom queries on the Customer entity.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    // JpaRepository provides basic CRUD operations without the need for explicit implementation.
    // You can add custom database queries here if needed.

}
