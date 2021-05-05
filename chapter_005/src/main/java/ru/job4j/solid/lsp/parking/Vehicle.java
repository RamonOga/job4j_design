package ru.job4j.solid.lsp.parking;

public abstract class Vehicle {

    public Vehicle(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    private String carNumber;

    public abstract int size();
}
