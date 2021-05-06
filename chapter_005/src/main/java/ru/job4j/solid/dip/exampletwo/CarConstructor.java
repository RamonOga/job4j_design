package ru.job4j.solid.dip.exampletwo;

public class CarConstructor {

    public Car carConstruct(Engine engine, Body body, Transmission transmission) {
        return new Car(engine, body, transmission);
    }
}
