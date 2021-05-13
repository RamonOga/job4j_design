package ru.job4j.solid.lsp.productstorage;

import ru.job4j.solid.lsp.productstorage.foods.Food;

import java.util.List;

public interface Storage {
    boolean add(Food food);
    List<Food> getFoodList();
    boolean accept(Food food);
}
