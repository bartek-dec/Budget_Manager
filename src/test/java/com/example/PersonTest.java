package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person();

        person.addIncome("100");
        person.getPurchases().add(new Purchase("Cinema", BigDecimal.valueOf(8.75), "Other"));
        person.getPurchases().add(new Purchase("Milk", BigDecimal.valueOf(3.50), "Food"));
    }

    @Test
    void whenAddedTwoProductsThenListSize_2() {
        assertEquals(2, person.getPurchases().size());
    }

    @Test
    void whenAdded_100_IncomeThenExpectThatIncome() {
        assertEquals(100, person.getBalance().doubleValue());
    }

    @Test
    void whenAdded_20_ExpenseThenBalance_80() {
        person.addExpense(BigDecimal.valueOf(20));

        assertEquals(80, person.getBalance().doubleValue());
    }

    @Test
    void whenAboveTwoProductsThenTotalPrice_12_25() {
        assertEquals(12.25, person.countTotal().doubleValue());
    }

    @Test
    void oneProductExpectedForOtherCategory() {
        List<Purchase> expected = person.findPurchaseForCategory(Category.OTHER);

        assertEquals(1, expected.size());
        assertEquals("Cinema", expected.get(0).getName());
    }

    @Test
    void whenAboveTwoProductsThenTotalPriceForOther_8_75() {
        assertEquals(8.75, person.countTotalForCategory(Category.OTHER).doubleValue());
    }
}