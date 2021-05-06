package ru.job4j.leetcode;

import java.util.Arrays;

public class LeetCode1502 {
    public static void main(String[] args) {
        int[] array = new int[]{3, 5, 1};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(canMakeArithmeticProgression(array));

    }
    public static boolean canMakeArithmeticProgression(int[] arr) {
        boolean rsl = true;
        Arrays.sort(arr);
        int dif = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] + dif != arr[i + 1]) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
