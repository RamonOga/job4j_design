package ru.job4j.solid.lsp.productstorage;

import ru.job4j.solid.lsp.productstorage.foods.Food;

public interface PercentCalculator {
    default int getPercentsFromBirthToDeath(Food food) {
        long validTime = food.getExpiryDate().getTime() - System.currentTimeMillis();
        long oneHundredPercents = food.getExpiryDate().getTime() - food.getCreateDate().getTime();
        int rsl = 100 - (int) ((100 * validTime) / oneHundredPercents);
        return rsl;
    }
}
