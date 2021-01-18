package ru.job4j.exam;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner<T extends Number> {
    public static void main(String[] args) {
        Map<Integer, User> u = new HashMap<>();
        u.put(1, new User(1, "2"));
        System.out.println(u.get(2));
    }
}

