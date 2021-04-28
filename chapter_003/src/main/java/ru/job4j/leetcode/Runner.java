package ru.job4j.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.computeIfAbsent(1, a -> map.put(1, a+1));
        map.put(1,1);
        map.put(1,1);
        map.put(1,1);
        System.out.println(map);
        int[] arr = Arrays.copyOfRange(new int[]{1,2,3}, 0 , 2);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] countBinary(int [] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println();
        }
        return null;
    }

    public static int binary(int x) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (x > 0) {
            if (x % 2 == 1) {
                count++;
            }
            x /= 2;
        }
        return count;
    }
}
