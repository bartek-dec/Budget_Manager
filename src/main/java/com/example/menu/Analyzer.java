package com.example.menu;

import com.example.Category;
import com.example.Person;
import com.example.Purchase;
import com.example.util.Printer;

import java.math.BigDecimal;
import java.util.*;

public class Analyzer implements CategoryGetter {

    private final String BAD_TYPE = "Bad type";
    private final String ALL = "All:";

    private Person person;
    private Scanner scanner;
    private Printer printer;

    public Analyzer(Person person, Scanner scanner) {
        this.person = person;
        this.scanner = scanner;
        this.printer = new Printer();
    }

    public void analyzeSubMenu() {
        List<Purchase> sorted;
        BigDecimal bill;
        int input = -1;
        do {
            sortOptions();
            try {
                input = Integer.parseInt(scanner.nextLine().trim());
                if (input < 1) {
                    System.out.println(BAD_TYPE);
                } else if (input == 1) {
                    sorted = sortPurchases(person.getPurchases());
                    bill = person.countTotal();

                    if (sorted.size() > 0) {
                        System.out.println(ALL);
                    }
                    printer.showAllPurchases(sorted, bill);
                } else if (input == 2) {
                    bill = person.countTotal();
                    printer.showTypes(sortTypes(), bill);
                    sortTypes();
                } else if (input == 3) {
                    typeOptions();

                    try {
                        input = Integer.parseInt(scanner.nextLine().trim());

                        if (input >= 1 && input <= 4) {
                            Category category = getCategory(input);
                            sorted = sortPurchases(person.findPurchaseForCategory(category));
                            bill = person.countTotalForCategory(category);

                            printer.showCategorizedPurchases(sorted, category, bill);
                        } else {
                            System.out.println(BAD_TYPE);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(BAD_TYPE);
                    }
                    input = 3;
                }
            } catch (NumberFormatException e) {
                System.out.println(BAD_TYPE);
            }

        } while (input != 4);
    }

    private void sortOptions() {
        System.out.println("How do you want to sort?");
        System.out.println("1) Sort all purchases");
        System.out.println("2) Sort by type");
        System.out.println("3) Sort certain type");
        System.out.println("4) Back\n");
    }

    private void typeOptions() {
        System.out.println("Choose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other\n");
    }

    private List<Purchase> sortPurchases(List<Purchase> list) {
        Collections.sort(list, (o1, o2) -> o2.getPrice().compareTo(o1.getPrice()));

        return list;
    }

    private List<Category> sortTypes() {
        List<Category> types = new ArrayList<>();

        for (Category c : getCategories()) {
            BigDecimal total = person.countTotalForCategory(c);
            c.setTotal(total);

            types.add(c);
        }
        Collections.sort(types, (o1, o2) -> o2.getTotal().compareTo(o1.getTotal()));
        return types;
    }
}
