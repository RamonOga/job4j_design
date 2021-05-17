package ru.job4j.solid.lsp.productstorage;

import ru.job4j.solid.lsp.productstorage.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class Temporary implements Storage {

    private List<Food> temporaryStorage;

    public Temporary() {
        temporaryStorage = new ArrayList<>();
    }

    @Override
    public boolean add(Food food) {
        temporaryStorage.add(food);
        return false;
    }

    public boolean addFoodList(List<Food> foodList) {
        if (foodList == null) {
            throw new IllegalArgumentException("Food list cannot be equal null");
        }
        int tmp = temporaryStorage.size();
        temporaryStorage.addAll(foodList);
        return tmp != temporaryStorage.size();
    }

    @Override
    public List<Food> getFoodList() {
        return temporaryStorage;
    }

    @Override
    public boolean accept(Food food) {
        return food != null;
    }

    @Override
    public void clear() {
        temporaryStorage.clear();
    }
}
