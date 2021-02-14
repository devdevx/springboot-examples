package com.devdevx.sb.examples;

import com.devdevx.sb.examples.item.Item;
import com.devdevx.sb.examples.item.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
class ApplicationTests {

    @Autowired
    ItemRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void dataExists() {
        Item found = repository.findByName("Test").orElse(null);
        assertNotNull(found);
        assertNotNull(found.getId());
        assertEquals("Test", found.getName());
    }
}
