package ru.job4j.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> rslSet = new HashSet<>();
        for (int j : nums1) {
            set.add(j);
        }
        for (int j : nums2) {
            if (set.contains(j)) {
                rslSet.add(j);
            }
        }
        int[] rsl = new int[rslSet.size()];

        int count = 0;
        for (Integer i : rslSet) {
            rsl[count++] = i;
        }

        return rsl;
    }
}
