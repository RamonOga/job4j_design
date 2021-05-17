package ru.job4j.solid.lsp.parking;

/**
 * @Class class for the Truck.
 * @author Markelov Roman
 */
public class Truck extends Vehicle {
    /**
     *@ Size of the Car
     */
    private final int size;

    /**
     * @param carNumber initializes name of the Truck
     * @param size initializes size of the Truck
     */
    public Truck(String carNumber, int size) {
        super(carNumber);
        if (size <= 1) {
            throw new IllegalArgumentException("Truck size cannot be less or equal to 1");
        }

        this.size = size;
    }

    /**
     * @return return size of the Truck
     */
    @Override
    public int size() {
        return size;
    }
}
