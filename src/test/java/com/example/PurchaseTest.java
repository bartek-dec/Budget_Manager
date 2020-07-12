package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest {

    private Purchase purchase;

    @BeforeEach
    void setUp() {
        purchase = new Purchase("Cinema", BigDecimal.valueOf(8.75), "Other");
    }

    @Test
    void testCategory() {
        assertEquals(Category.OTHER, purchase.getCategory());
    }

    @Test
    void testPrice() {
        assertEquals(BigDecimal.valueOf(8.75),purchase.getPrice());
    }

    @Test
    void testName() {
        assertEquals("Cinema",purchase.getName());
    }
}