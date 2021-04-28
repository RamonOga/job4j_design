package ru.job4j.solid.lsp.productstorage;

import ru.job4j.solid.lsp.productstorage.foods.Food;

public interface Storage {
    boolean add(Food food);

    boolean accept(Food food);
}
