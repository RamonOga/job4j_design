package ru.job4j.leetcode;

import java.util.Arrays;
import java.util.Random;

public class Helper {
    private static final Random random = new Random();

    public static int[] createRandomIntArray(int size) {
        int[] rsl = new int[size];
        for (int i = 0; i < size; i++) {
            rsl[i] = random.nextInt(10);
        }
        System.out.println("Created int[], size = " + size + "\n " + Arrays.toString(rsl));
        return rsl;
    }

    public static int[] createSortedIntArray(int size) {
        int[] rsl = new int[size];
        for (int i = 0; i < size; i++) {
            rsl[i] = i;
        }
        System.out.println("Created int[], size = " + size + "\n " + Arrays.toString(rsl));
        return rsl;
    }

}
