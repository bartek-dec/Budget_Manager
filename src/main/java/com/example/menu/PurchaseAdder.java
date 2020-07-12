package com.example.menu;

import com.example.Category;
import com.example.Person;
import com.example.Purchase;

import java.math.BigDecimal;
import java.util.Scanner;

public class PurchaseAdder implements CategoryGetter{

    private final String BAD_TYPE = "Bad type";

    private Scanner scanner;
    private Person person;

    public PurchaseAdder(Scanner scanner, Person person) {
        this.scanner = scanner;
        this.person = person;
    }

    public void categorySubMenu() {
        int input = -1;
        do {
            categoryOptions();
            try {
                input = Integer.parseInt(scanner.nextLine().trim());

                if (input >= 1 && input <= 4) {
                    addPurchase(getCategory(input));
                } else if (input < 1) {
                    System.out.println(BAD_TYPE);
                }
            } catch (NumberFormatException e) {
                System.out.println(BAD_TYPE);
            }

        } while (input != 5);
    }

    private void categoryOptions() {
        System.out.println("Choose the type of purchase:");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) Back\n");
    }

    private void addPurchase(Category category) {
        System.out.println();
        System.out.println("Enter purchase name:");
        String name = scanner.nextLine().trim();

        System.out.println("Enter its price:");
        String price = scanner.nextLine().trim();

        try {
            double number = Double.parseDouble(price);

            if (number <= person.getBalance().doubleValue() && number >= 0) {
                BigDecimal bigDecimal = new BigDecimal(price);
                Purchase purchase = new Purchase(name, bigDecimal, category);

                person.getPurchases().add(purchase);
                person.addExpense(bigDecimal);

                System.out.println("Purchase was added!\n");
            } else {
                System.out.println("Purchase is too expensive\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("Bad price\n");
        }
    }
}
