package ru.job4j.solid.lsp.parking;

import java.util.NoSuchElementException;

/**
 * @auther Markelov Roman
 * Class is park cars and trucks.
 */
public class ParkingStorage implements Parking {
    /**
     * array for cars
     */
    private final Vehicle[] carsList;
    /**
     * cars position
     */
    private int carsPosition;
    /**
     * array for trucks
     */
    private final Vehicle[] trucksList;
    /**
     * truck position
     */
    private int truckPosition;

    /**
     * Constructor for parking
     * @param carsSize cars parking size
     * @param trucksSize truck parking size
     */
    public ParkingStorage(int carsSize, int trucksSize) {
        carsList = new Vehicle[carsSize];
        carsPosition = 0;
        trucksList = new Vehicle[trucksSize];
        truckPosition = 0;
    }

    /**
     *
     * @param vehicle Vehicle to park
     * @return if Vehicle parked, return true. Else return false
     */
    @Override
    public boolean park(Vehicle vehicle) {
        boolean rsl = false;

        if (vehicle.size() < 1) {
            throw new IllegalArgumentException("Wrong vehicle size.");
        }

        if (vehicle.size() == 1 && carsPosition < carsList.length) {
            carsList[carsPosition++] = vehicle;
            rsl = true;
        }
        if (vehicle.size() > 1 && truckPosition < trucksList.length) {
            trucksList[truckPosition++] = vehicle;
            rsl = true;
        } else if (vehicle.size() <= carsList.length - carsPosition) {
            for (int i = 0; i < vehicle.size(); i++ ) {
                carsList[carsPosition++] = vehicle;
                rsl = true;
            }
        }

        return rsl;
    }

    /**
     * method return Vehicle this input carNumber
     * @param carNumber name of the Car
     * @return Vehicle this input carNumber
     */
    @Override
    public Vehicle get(String carNumber) {
        Vehicle rsl = null;
        if (carsPosition != 0) {
             rsl = getVehicle(carsList, carNumber);
        }
        if (rsl == null && truckPosition != 0) {
            rsl = getVehicle(trucksList, carNumber);
        }
        if (rsl == null) {
            throw new NoSuchElementException("Vehicle with this number was not found");
        }
        return rsl;
    }

    /**
     * Method is looking for a free space for a Truck to park it in the cars park.
     * @param vehicles
     * @param carNumber
     * @return
     */
    private Vehicle getVehicle(Vehicle[] vehicles, String carNumber) {
        Vehicle rsl = null;
        for (Vehicle veh : vehicles) {
            if (veh.getCarNumber().equals(carNumber)) {
                rsl = veh;
                break;
            }
        }
        return rsl;
    }
}
