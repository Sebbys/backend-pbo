package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DatabaseConnectionTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testDatabaseConnection() {
        // Attempt to query the database
        Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
        // Verify the result
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void testTableExists() {
        // Check if the PBO_Pagi table exists
        Integer count = jdbcTemplate.queryForObject(
            "SELECT COUNT(*) FROM information_schema.tables WHERE table_name = 'PBO_Pagi'", 
            Integer.class
        );
        // Verify the table exists
        assertThat(count).isEqualTo(1);
    }
}
