package ru.job4j.solid.lsp.parking;

public class Car extends Vehicle {

    private final int size;

    public Car(String carNumber) {
        super.carNumber = carNumber;
        size = 1;
    }


    public String getCarNumber() {
        return carNumber;
    }
    @Override
    public int size() {
        return size;
    }
}
