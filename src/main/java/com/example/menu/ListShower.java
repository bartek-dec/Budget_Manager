package com.example.menu;

import com.example.Category;
import com.example.Person;
import com.example.Purchase;
import com.example.util.Printer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ListShower implements CategoryGetter {

    private final String BAD_TYPE = "Bad type";

    private Scanner scanner;
    private Person person;
    private Printer printer;

    public ListShower(Scanner scanner, Person person) {
        this.scanner = scanner;
        this.person = person;
        this.printer = new Printer();
    }

    public void listSubMenu() {
        List<Purchase> purchases;
        BigDecimal bill;
        int input = -1;
        do {
            listOptions();
            try {
                input = Integer.parseInt(scanner.nextLine().trim());

                if (input >= 1 && input <= 4) {
                    Category category = getCategory(input);
                    purchases = person.findPurchaseForCategory(category);
                    bill = person.countTotalForCategory(category);

                    printer.showCategorizedPurchases(purchases, category, bill);
                } else if (input == 5) {
                    purchases = person.getPurchases();
                    bill = person.countTotal();

                    printer.showAllPurchases(purchases, bill);
                } else if (input < 1) {
                    System.out.println(BAD_TYPE);
                }
            } catch (NumberFormatException e) {
                System.out.println(BAD_TYPE);
            }

        } while (input != 6);
    }

    private void listOptions() {
        System.out.println("Choose the type of purchase:");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) All");
        System.out.println("6) Back\n");
    }
}
