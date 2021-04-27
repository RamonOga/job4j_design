package ru.job4j.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortArrayByParityII {

    public static void main(String[] args) {
        int[] ar = new int[]{4, 2, 5, 7};
        System.out.println(Arrays.toString(sortArrayByParityII(ar)));
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int[] rsl = new int[nums.length];
        int hlp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                rsl[hlp] = nums[i];
                hlp += 2;
            }
        }
        hlp = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                rsl[hlp] = nums[i];
                hlp += 2;
            }
        }
        return rsl;
    }
}
