package ru.job4j.exam;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        User u1 = new User(1, "2");
        User u2 = new User(1, "123");
        System.out.println(u1.equals(u2));
    }
}

