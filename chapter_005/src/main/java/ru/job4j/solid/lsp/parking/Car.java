package ru.job4j.solid.lsp.parking;

/**
 * @Class class for the Car.
 * @author Markelov Roman
 */
public class Car extends Vehicle {
    /**
     *@ Size of the Car
     */
    private final int size;
    /**
     * @param carNumber name of the Car
     */
    public Car(String carNumber) {
        super(carNumber);
        size = 1;
    }
    /**
     * @return return the size of the Car
     */
    @Override
    public int size() {
        return size;
    }
}
