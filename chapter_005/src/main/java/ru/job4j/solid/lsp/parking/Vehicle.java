package ru.job4j.solid.lsp.parking;

public abstract class Vehicle {

    public Vehicle(String carNumber) {
        this.carNumber = carNumber;
    }

    private final String carNumber;

    public String getCarNumber() {
        return carNumber;
    }

    public abstract int size();
}
