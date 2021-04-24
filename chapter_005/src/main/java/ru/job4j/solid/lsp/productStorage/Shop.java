package ru.job4j.solid.lsp.productStorage;

public class Shop{
    FoodStorage foodStorage;

    public Shop() {
        this.foodStorage = new FoodStorage();
    }
}
