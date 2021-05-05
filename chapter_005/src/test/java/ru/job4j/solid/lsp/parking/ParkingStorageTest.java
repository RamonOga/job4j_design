package ru.job4j.solid.lsp.parking;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ParkingStorageTest {

    @Test
    public void whenAddCar() {
        Parking parking = new ParkingStorage(2);
        Vehicle car = new Car("a001bc");
        parking.park(car);
        assertEquals(car, parking.get("a001bc"));
    }

    @Test
    public void whenAddTruck() {
        Parking parking = new ParkingStorage(2);
        Vehicle truck = new Truck("a002bc");
        parking.park(truck);
        assertEquals(truck, parking.get("a002bc"));
    }

    @Test
    public void whenAddTruckWithOutSpiceInParking() {
        Parking parking = new ParkingStorage(1);
        Vehicle truck = new Truck("a002bc");
        assertFalse(parking.park(truck));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenParkingNotHaveThisVehicle() {
        Parking parking = new ParkingStorage(1);
        parking.get("a002bc");
    }
}