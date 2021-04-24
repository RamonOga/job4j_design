package ru.job4j.solid.lsp.productStorage;

public class Warehouse {
    FoodStorage foodStorage;

    public Warehouse() {
        this.foodStorage = new FoodStorage();
    }
}
