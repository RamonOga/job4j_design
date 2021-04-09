package ru.job4j.leetcode;

import java.util.Arrays;

public class ShuffleTheArray {

    public static void main(String[] args) {
        int [] array = Helper.createSortedIntArray(10);
        System.out.println(Arrays.toString(shuffle(array, 5)));
    }

    public static int[] shuffle(int[] nums, int n) {
            int[] rsl = new int[nums.length];
            int count = 0;
            for (int i = 0; i < nums.length / 2; i++) {
                rsl[count++] = nums[i];
                rsl[count++] = nums[n];
                n++;
        }
        return rsl;
    }
}

//[1, 2, 3, 4, 5 ,6] n = 3