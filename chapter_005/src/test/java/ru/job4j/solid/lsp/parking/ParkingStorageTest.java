package ru.job4j.solid.lsp.parking;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ParkingStorageTest {

    @Test
    public void whenAddCar() {
        Parking parking = new ParkingStorage(10, 10);
        Vehicle car = new Car("a001bc");
        parking.park(car);
        assertEquals(car, parking.get("a001bc"));
    }

    @Test
    public void whenAddTruck() {
        Parking parking = new ParkingStorage(10, 10);
        Vehicle truck = new Truck("a002bc", 2);
        parking.park(truck);
        assertEquals(truck, parking.get("a002bc"));
    }

    @Test
    public void whenAddTruckWithOutSpiceInParking() {
        Parking parking = new ParkingStorage(1, 0);
        Vehicle truck = new Truck("a002bc", 2);
        assertFalse(parking.park(truck));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenParkingNotHaveThisVehicle() {
        Parking parking = new ParkingStorage(10, 10);
        parking.get("a002bc");
    }

    @Test
    public void whenAddSoManyTrucks() {
        Parking parking = new ParkingStorage(10, 2);
        Vehicle truck1 = new Truck("a001bc", 5);
        Vehicle truck2 = new Truck("a002bc", 5);
        Vehicle truck3 = new Truck("a003bc", 5);
        Vehicle truck4 = new Truck("a004bc", 5);
        parking.park(truck1);
        parking.park(truck2);
        parking.park(truck3);
        parking.park(truck4);
        parking.park(truck4);
        assertEquals(truck1, parking.get("a001bc"));
        assertEquals(truck2, parking.get("a002bc"));
        assertEquals(truck3, parking.get("a003bc"));
        assertEquals(truck4, parking.get("a004bc"));
    }

    @Test
    public void whenAddInFullParking() {
        Parking parking = new ParkingStorage(5, 1);
        Vehicle truck1 = new Truck("a001bc", 5);
        Vehicle truck2 = new Truck("a002bc", 5);
        Vehicle truck3 = new Truck("a003bc", 5);
        parking.park(truck1);
        parking.park(truck2);
        assertFalse(parking.park(truck3));
    }
}