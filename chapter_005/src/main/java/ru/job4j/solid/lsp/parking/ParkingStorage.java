package ru.job4j.solid.lsp.parking;

public class ParkingStorage implements Parking {
    @Override
    public boolean park(Vehicle vehicle) {
        return false;
    }

    @Override
    public Vehicle get(int id) {
        return null;
    }
}
