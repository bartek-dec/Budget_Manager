package com.example.menu;

import com.example.Person;

public class BalanceShower {

    private Person person;

    public BalanceShower(Person person) {
        this.person = person;
    }

    public void showBalance() {
        System.out.printf("Balance: $%.2f", person.getBalance().doubleValue());
        System.out.println("\n");
    }
}
