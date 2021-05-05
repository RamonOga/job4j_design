package ru.job4j.solid.lsp.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ParkingStorage implements Parking {

    private int storageSize;
    List<Vehicle> vehicleList;

    public ParkingStorage(int size) {
        storageSize = size;
        vehicleList = new ArrayList<>();
    }

    @Override
    public boolean park(Vehicle vehicle) {
        boolean rsl = storageSize >= vehicle.size();
        if (rsl) {
            storageSize -= vehicle.size();
            vehicleList.add(vehicle);
        }
        return rsl;
    }

    @Override
    public Vehicle get(String carNumber) {
        Optional<Vehicle> rsl = vehicleList.stream()
                .filter(a -> a.getCarNumber().equals(carNumber))
                .findFirst();
        if (rsl.isEmpty()) {
            System.out.println("ebat' prikolachivat'");
           throw new NoSuchElementException("There is no vehicle with this number in the parking lot.");

        }
        return rsl.get();
    }
}
