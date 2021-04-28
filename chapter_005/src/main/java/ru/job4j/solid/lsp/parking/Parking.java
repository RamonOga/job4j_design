package ru.job4j.solid.lsp.parking;

public interface Parking {
    boolean park(Vehicle Vehicle);
    Vehicle get(int id);
}
