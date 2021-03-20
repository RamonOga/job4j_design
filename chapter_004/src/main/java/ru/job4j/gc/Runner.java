package ru.job4j.gc;


import java.util.HashMap;
import java.util.Map;

public class Runner {

    private static Map<String, String> stringContainer = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Start of program!");
        String stringWithPrefix = "stringWithPrefix";

        // Load Java Heap with 3 M java.lang.String instances
        for (int i = 0; i < 3000000; i++) {
            String newString = stringWithPrefix + i;
            stringContainer.put(newString, newString);
        }
        System.out.println("MAP size: " + stringContainer.size());

        // Explicit GC!
        System.gc();

        // Remove 2 M out of 3 M
        for (int i = 0; i < 2000000; i++) {
            String newString = stringWithPrefix + i;
            stringContainer.remove(newString);
        }

        System.out.println("MAP size: " + stringContainer.size());
        System.out.println("End of program!");
    }
}
