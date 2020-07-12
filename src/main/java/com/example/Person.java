package com.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private BigDecimal balance;
    private List<Purchase> purchases;

    public Person() {
        this.purchases = new ArrayList<>();
        balance = BigDecimal.ZERO;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void addIncome(String income) {
        BigDecimal newBalance = balance.add(new BigDecimal(income));
        this.balance = newBalance;
    }

    public void addExpense(BigDecimal bigDecimal) {
        BigDecimal newBalance = balance.subtract(bigDecimal);
        this.balance = newBalance;
    }

    public List<Purchase> findPurchaseForCategory(Category category) {
        List<Purchase> categorized = purchases.stream()
                .filter(e -> e.getCategory().equals(category))
                .collect(Collectors.toList());
        return categorized;
    }

    public BigDecimal countTotal() {
        BigDecimal sum = purchases.stream()
                .map(s -> s.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return sum;
    }

    public BigDecimal countTotalForCategory(Category category) {
        BigDecimal sum = purchases.stream()
                .filter(e -> e.getCategory().equals(category))
                .map(s -> s.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return sum;
    }
}
