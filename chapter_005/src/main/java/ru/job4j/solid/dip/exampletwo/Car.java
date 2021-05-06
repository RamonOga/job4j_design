package ru.job4j.solid.dip.exampletwo;

public class Car {
    Engine engine;
    Body body;
    Transmission transmission;

    public Car(Engine engine, Body body, Transmission transmission) {
        this.engine = engine;
        this.body = body;
        this.transmission = transmission;
    }
}
