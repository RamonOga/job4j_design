package ru.job4j.tdd;

import java.util.Map;

public interface Generator {
    String produce(String template, Map<String, String> args);
}
