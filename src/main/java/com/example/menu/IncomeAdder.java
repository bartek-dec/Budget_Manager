package com.example.menu;

import com.example.Person;

import java.util.Scanner;

public class IncomeAdder {

    private Scanner scanner;
    private Person person;

    public IncomeAdder(Scanner scanner, Person person) {
        this.scanner = scanner;
        this.person = person;
    }

    public void addIncome() {
        System.out.println("Enter income:");
        String income = scanner.nextLine().trim();
        try {
            double number = Double.parseDouble(income);

            if (number >= 0) {
                person.addIncome(income);
                System.out.println("Income was added!\n");
            } else {
                System.out.println("Income can not be negative\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("Bad income\n");
        }
    }
}
