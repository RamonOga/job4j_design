package ru.job4j.solid.lsp.productstorage;

import ru.job4j.solid.lsp.productstorage.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
    List<Food> foodStorage;
    private final int upLimit = 75;
    private final int downLimit = 25;

    public Shop() {
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
        int percents = getPercentsFromBirthToDeath(food);
        if (percents <= upLimit && percents >= downLimit) {
            return true;
        } else if (percents >= upLimit && percents < 100) {
            food.setDiscount(true);
            return true;
        }
        return false;
    }

}
