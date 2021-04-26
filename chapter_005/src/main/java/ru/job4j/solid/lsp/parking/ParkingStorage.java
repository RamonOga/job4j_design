package ru.job4j.solid.lsp.parking;

public class ParkingStorage implements IParking {
    @Override
    public boolean park(Car car) {
        return false;
    }
}
