package ru.job4j.leetcode;

public class MaxAscendingSum {
    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{100, 20, 130, 5, 10, 50}));
        System.out.println(maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
    }

    public static int maxAscendingSum(int[] nums) {
        int sum = nums[0];
        int rsl = sum;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                sum += nums[i];
                if (rsl < sum) {
                    rsl = sum;
                }
            } else {
                sum = nums[i];
            }
        }
        return rsl;
    }
}
