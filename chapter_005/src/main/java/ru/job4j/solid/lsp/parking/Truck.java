package ru.job4j.solid.lsp.parking;

public class Truck extends Vehicle {
    public Truck(String carNumber) {
        super(carNumber);
    }

    @Override
    public int size() {
        return 2;
    }
}
