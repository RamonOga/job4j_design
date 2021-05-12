package ru.job4j.solid.dip.exampletwo;

import java.util.List;
import java.util.function.Predicate;

public class CarConstructor {
    List<Body> bodies;
    List<Engine> engines;
    List<Transmission> transmissions;

    public Car carConstruct(Predicate<Body> bodyPredicate,
                            Predicate<Engine> enginePredicate,
                            Predicate<Transmission> transmissionPredicate) {
        return new Car(findEngine(enginePredicate),
                findBody(bodyPredicate),
                findTransmission(transmissionPredicate));
    }

    private Body findBody(Predicate<Body> predicate) {
        return bodies.stream().filter(predicate).findFirst().get();
    }
    private Engine findEngine(Predicate<Engine> predicate) {
        return engines.stream().filter(predicate).findFirst().get();
    }
    private Transmission findTransmission(Predicate<Transmission> predicate) {
        return transmissions.stream().filter(predicate).findFirst().get();
    }
}
