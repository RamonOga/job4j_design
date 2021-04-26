package ru.job4j.solid.lsp.productStorage;

import ru.job4j.solid.lsp.productStorage.foods.Food;

public interface Storage {
    boolean add(Food food);
    boolean accept(Food food);
    default int getPercents(Food food) {
        long validTime = food.getExpiryDate().getTime() - System.currentTimeMillis();
        long oneHundredPercents = food.getExpiryDate().getTime() - food.getCreateDate().getTime();
        return (int) ((100 * validTime) / oneHundredPercents);
    }
}
