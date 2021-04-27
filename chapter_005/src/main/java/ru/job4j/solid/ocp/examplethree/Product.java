package ru.job4j.solid.ocp.examplethree;

public abstract class Product {
    private int capacity;

    public void addInPizza(int capacity) {
        this.capacity -= capacity;
    }
}
