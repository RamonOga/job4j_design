package ru.job4j.solid.ocp.exampleThree;

public class Dough extends Product {

    private int capacity;

    public Dough(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void addInPizza(int capacity) {
        this.capacity -= capacity;
    }
}
