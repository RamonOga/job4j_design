package ru.job4j.leetcode;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = new int[]{0};
        System.out.println(canPlaceFlowers(flowerbed, 1));

    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0, i = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0
                    && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }
}
