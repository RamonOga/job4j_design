package ru.job4j.solid.lsp.productstorage;

import ru.job4j.solid.lsp.productstorage.foods.Food;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Warehouse implements Storage {
    List<Food> foodStorage;
    private final int limit = 25;

    public Warehouse() {
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
        return percents <= limit && percents > 0;
    }
}
