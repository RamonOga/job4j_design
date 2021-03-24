package ru.job4j.gc;

import java.util.*;

public class GCTypeDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(30000);
        Random random = new Random();
        int length = 100;
        List<Person> personList = new ArrayList<>();
        String[] data = new String[1_000_000];
        for (int i = 0; ; i = (i + 1) % data.length) {
            data[i] = String.valueOf(
                    (char) random.nextInt(255)
            ).repeat(length);
            personList.add(new Person(1, "name"));
        }
    }
}