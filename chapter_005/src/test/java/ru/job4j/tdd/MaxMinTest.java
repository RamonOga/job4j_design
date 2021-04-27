package ru.job4j.tdd;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void maxTest() {
        MaxMin mx = new MaxMin();
        List<Integer> list = new ArrayList<>();
        list.add(999);
        list.add(444);
        list.add(111);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(mx.max(list, comparator));
        System.out.println(mx.min(list, comparator));
    }
}