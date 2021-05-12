package ru.job4j.solid.dip.exampleone;

import java.util.List;

public interface Service {
    boolean addDeveloper(Developer developer);
    boolean removeDeveloper(Developer developer);
    List<String> doWork(List<String> workCode);
}

