package ru.job4j.solid.lsp.parking;

public abstract class Vehicle {
    protected String carNumber;

    public abstract int size();
    public Vehicle(){};
    public String getCarNumber() {
        return carNumber;
    }
}
