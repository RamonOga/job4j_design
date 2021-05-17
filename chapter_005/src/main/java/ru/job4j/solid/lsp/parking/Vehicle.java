package ru.job4j.solid.lsp.parking;

/**
 * @class Abstract class for Cars and Trucks
 * @author Markerlov Roman
 *
 */
public abstract class Vehicle {
    /**
     * name of the Car
     */
    private String carNumber;

    /**
     *
     * @return size of the Car
     */
    public abstract int size();

    /**
     *
     * @param carNumber
     */
    public Vehicle(String carNumber) {
        this.carNumber = carNumber;
    }

    /**
     *
     * @return return name of the Car
     */
    public String getCarNumber() {
        return carNumber;
    }
}
