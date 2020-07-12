package com.example.util;

import com.example.Category;
import com.example.Purchase;

import java.math.BigDecimal;
import java.util.List;

public class Printer {

    public void showAllPurchases(List<Purchase> purchases, BigDecimal balance) {
        if (purchases.size() == 0) {
            System.out.println("Purchase list is empty!\n");
        } else {
            for (Purchase p : purchases) {
                System.out.printf("%s $%.2f", p.getName(), p.getPrice().doubleValue());
                System.out.println();
            }
            System.out.printf("Total: $%.2f", balance.doubleValue());
            System.out.println("\n");
        }
    }

    public void showCategorizedPurchases(List<Purchase> purchases, Category category, BigDecimal balance) {
        if (purchases.size() == 0) {
            System.out.println("Purchase list is empty!\n");
        } else {
            System.out.println("\n" + category + ":");
            for (Purchase p : purchases) {
                System.out.printf("%s $%.2f", p.getName(), p.getPrice().doubleValue());
                System.out.println();
            }
            System.out.printf("Total: $%.2f", balance.doubleValue());
            System.out.println("\n");
        }
    }

    public void showTypes(List<Category> categories, BigDecimal balance) {
        System.out.println("\nTypes:");

        for (Category category : categories) {
            System.out.printf("%s - $%.2f", category.toString(), category.getTotal().doubleValue());
            System.out.println();
        }

        System.out.printf("Total: $%.2f", balance.doubleValue());
        System.out.println("\n");
    }
}
