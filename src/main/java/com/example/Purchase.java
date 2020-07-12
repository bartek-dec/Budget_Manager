package com.example;

import java.math.BigDecimal;

public class Purchase {

    private String name;
    private BigDecimal price;
    private Category category;

    public Purchase(String name, BigDecimal price, Category category) {
        this(name, price);
        this.category = category;
    }

    public Purchase(String name, BigDecimal price, String category) {
        this(name, price);
        this.category = matchCategory(category);
    }

    private Purchase(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    private Category matchCategory(String s) {
        switch (s) {
            case "Food":
                return Category.FOOD;
            case "Clothes":
                return Category.CLOTHES;
            case "Entertainment":
                return Category.ENTERTAINMENT;
            case "Other":
                return Category.OTHER;
            default:
                return null;
        }
    }
}
