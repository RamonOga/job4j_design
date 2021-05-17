package ru.job4j.solid.lsp.parking;

public class Car extends Vehicle {

    private final int size;

    public Car(String carNumber) {
        super(carNumber);
        size = 1;
    }

    @Override
    public int size() {
        return size;
    }
}
