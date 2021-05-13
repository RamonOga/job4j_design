package ru.job4j.solid.lsp.parking;

import java.util.NoSuchElementException;

public class ParkingStorage implements Parking {

    private Vehicle[] carsList;
    private Vehicle[] tracksList;

    public ParkingStorage(int carsSize, int tracksSize) {
        carsList = new Vehicle[carsSize];
        tracksList = new Vehicle[tracksSize];
    }

    @Override
    public boolean park(Vehicle vehicle) {
        boolean rsl = false;
        if (vehicle == null || vehicle.size() <= 0) {
            throw new IllegalArgumentException("Vehicle was so not the correct size or equals null!");
        }

        if (vehicle.size() == 1) {
           rsl = putVehicle(carsList, vehicle);
        }
        if (vehicle.size() > 1) {
            rsl = putVehicle(tracksList, vehicle);
            if(!rsl) {
                rsl = putTrackInCarsStorage(tracksList, vehicle);
            }
        }
        return rsl;
    }

    private boolean putVehicle(Vehicle[] storage, Vehicle vehicle) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = vehicle;
                return true;
            }
        }
        return false;
    }

    private boolean putTrackInCarsStorage(Vehicle[] storage, Vehicle vehicle) {
        int count = vehicle.size();
        for (int i = 0; i < storage.length - vehicle.size(); i++) {
            if (storage[i] == null && findFreePlaceForTruck(storage, i, vehicle.size())) {
                while (count != 0) {
                    storage[i] = vehicle;
                    count--;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public Vehicle get(String carNumber) {
        Vehicle rsl;
        if (carNumber == null) {
            throw new IllegalArgumentException("Vehicle name cannot be null!");
        }
        rsl = getFromCarsList(carNumber);
        if (rsl == null) {
            rsl = getFromTrackList(carNumber);
        }
        if (rsl == null) {
            throw new NoSuchElementException("Vehicle with " + carNumber + " no found.");
        }
        return rsl;
    }

    private Vehicle getFromCarsList(String carNumber) {
        Vehicle rsl = null;
        for (int i = 0; i < carsList.length; i ++) {
            if (carsList[i] != null && carsList[i].getCarNumber().equals(carNumber)) {
                if (carsList[i].size() > 1) {
                    rsl = carsList[i];
                    int count = rsl.size();
                    while (count != 0) {
                        carsList[i] = null;
                        i++;
                        count--;
                    }
                    break;
                } else {
                    rsl = carsList[i];
                    carsList[i] = null;
                    break;
                }
            }
        }
        return rsl;
    }

    private Vehicle getFromTrackList(String carNumber) {
        Vehicle rsl = null;
        for (int i = 0; i < tracksList.length; i ++) {
            if (tracksList[i] != null && tracksList[i].getCarNumber().equals(carNumber)) {
                    rsl = tracksList[i];
                    tracksList[i] = null;
                    break;
            }
        }
        return rsl;
    }

    public boolean findFreePlaceForTruck(Vehicle[] vehicles, int index, int size) {
        boolean rsl = true;
        for (int i = index; i < index + size; i++) {
                if (vehicles[i] != null) {
                    rsl = false;
                    break;
            }
        }
        return rsl;
    }
}
