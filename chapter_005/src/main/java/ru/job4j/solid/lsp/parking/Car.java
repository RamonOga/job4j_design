package ru.job4j.solid.lsp.parking;

public class Car extends Vehicle {

    private final int size;

    public Car(String carNumber, int size) {
        if (size != 1) {
            throw new IllegalArgumentException("Car's size must equal to 1");
        }
        super.carNumber = carNumber;
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
