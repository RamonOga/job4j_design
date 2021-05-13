package ru.job4j.solid.lsp.productstorage;

import ru.job4j.solid.lsp.productstorage.foods.Food;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trash implements Storage {
    List<Food> foodStorage;

    public Trash() {
        this.foodStorage = new ArrayList<>();
    }

    @Override
    public boolean add(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Food cannot be null!");
        }
        boolean rsl = accept(food);
        if (rsl) {
            foodStorage.add(food);
        }
        return rsl;
    }

    @Override
    public boolean accept(Food food) {
        boolean rsl = food.getExpiryDate().getTime() < Calendar.getInstance().getTime().getTime();
        if (rsl) {
            foodStorage.add(food);
            return true;
        }
        return false;
    }

    @Override
    public List<Food> getFoodList() {
        return foodStorage;
    }
}
