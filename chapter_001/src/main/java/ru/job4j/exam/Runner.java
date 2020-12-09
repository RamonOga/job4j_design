package ru.job4j.exam;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<? extends Number> list1 = new ArrayList<>();
        List<? super Number> list2 = new ArrayList<>();
        Number n = 12;
        Object o = 12;
        Integer i = 12;
        list1.add(n);
        list2.add(n);
        list1.add(o);
        list2.add(o);
        list1.add(i);
        list2.add(i);
    }
}

