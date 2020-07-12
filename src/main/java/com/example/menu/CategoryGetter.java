package com.example.menu;

import com.example.Category;

import java.util.ArrayList;
import java.util.List;

public interface CategoryGetter {

    default Category getCategory(int categoryNumber) {
        switch (categoryNumber) {
            case 1:
                return Category.FOOD;
            case 2:
                return Category.CLOTHES;
            case 3:
                return Category.ENTERTAINMENT;
            case 4:
                return Category.OTHER;
            default:
                return null;
        }
    }

    default List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();

        categories.add(Category.FOOD);
        categories.add(Category.CLOTHES);
        categories.add(Category.ENTERTAINMENT);
        categories.add(Category.OTHER);

        return categories;
    }
}
