package ru.job4j.leetcode;

public class LeetcodeBank {
    public static void main(String[] args) {
       // System.out.println(totalMoney(4));
        System.out.println(totalMoney1(7));
        System.out.println(totalMoney1(10));
        System.out.println(totalMoney2(7));
        System.out.println(totalMoney2(10));
    }

    public static int totalMoney1(int n) {
        int weak = 0;
        int cost = 1;
        int rsl = 0;
        for (int i = 0; i != n; i++) {
            if (cost - weak > 7) {
                weak++;
                cost = weak + 1;
            }
            rsl += cost;
            cost++;
        }
        return rsl;
    }

    public static int totalMoney2(int n) {
        int rsl = 0;
        int moneyPerWeek = 28;
        int weeks = n / 7;
        int restOfDays = n % 7;

        for (int i = 0; i != weeks; i++) {
            rsl += moneyPerWeek + ( 7 * i);
        }
        for (int i = 0; i != restOfDays; i++) {
            weeks++;
            rsl += weeks;
        }
        return rsl;
    }
}
