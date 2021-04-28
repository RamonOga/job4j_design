package ru.job4j.solid.lsp.parking;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingStorageTest {

    @Test
    public void whenAddCar() {
        Parking parking = new ParkingStorage();
        Vehicle car = new Car();
        parking.park(car);
        assertEquals(car, parking.get(1));
    }

    @Test
    public void whenAddTruck() {
        Parking parking = new ParkingStorage();
        Vehicle truck = new Truck();
        parking.park(truck);
        assertEquals(truck, parking.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAddTruckWithOutSpiceInParking() {
        Parking parking = new ParkingStorage();
        Vehicle truck = new Truck();
        parking.park(truck);
    }
}