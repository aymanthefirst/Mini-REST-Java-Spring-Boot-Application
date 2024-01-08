package com.example.customerapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * DatabaseConnectionTest to verify the database connection.
 */
@SpringBootTest
@ActiveProfiles("test") // Ensure you are using a test profile that points to a test database
public class DatabaseConnectionTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testConnection() {
        assertNotNull(jdbcTemplate, "JdbcTemplate should be auto-wired (not null)");
        jdbcTemplate.execute("SELECT 1"); // Simple query to test the connection
    }
}
