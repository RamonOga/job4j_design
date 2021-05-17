package ru.job4j.solid.lsp.parking;

/**
 * Interfice for parking
 */
public interface Parking {
    /**
     * @param Vehicle
     * @return If add Vehicle success, return true else true
     */
    boolean park(Vehicle Vehicle);
    /**
     * @param carNumber name of the Car
     * @return return Car with input name.
     */
    Vehicle get(String carNumber);
}
