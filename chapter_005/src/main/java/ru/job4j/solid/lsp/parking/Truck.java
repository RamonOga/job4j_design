package ru.job4j.solid.lsp.parking;

public class Truck extends Vehicle {
    private final int size;

    public Truck(String carNumber, int size) {
        if (size <= 1) {
            throw new IllegalArgumentException("Truck size cannot be less or equal to 1");
        }
        this.carNumber = carNumber;
        this.size = size;
    }


    public String getCarNumber() {
        return carNumber;
    }

    @Override
    public int size() {
        return size;
    }
}
