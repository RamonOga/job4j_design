package ru.job4j.solid.lsp.parking;

public class Car extends Vehicle {
    public Car(String carNumber) {
        super(carNumber);
    }

    @Override
    public int size() {
        return 1;
    }
}
