package ru.job4j.solid.lsp.parking;

import java.util.NoSuchElementException;

public class ParkingStorage implements Parking {

    private final Vehicle[] carsList;
    private int carsPosition;
    private final Vehicle[] trucksList;
    private int truckPosition;


    public ParkingStorage(int carsSize, int trucksSize) {
        carsList = new Vehicle[carsSize];
        carsPosition = 0;
        trucksList = new Vehicle[trucksSize];
        truckPosition = 0;
    }

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
