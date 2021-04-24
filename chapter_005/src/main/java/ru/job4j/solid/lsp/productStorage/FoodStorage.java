package ru.job4j.solid.lsp.productStorage;

import ru.job4j.solid.lsp.productStorage.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodStorage {
    List<Food> foodsList;

    public FoodStorage() {
        this.foodsList = new ArrayList<>();
    }

    public void add(Food food) {
        foodsList.add(food);
    }


    public List<Food> getFoodList() {
        return foodsList;
    }

}
