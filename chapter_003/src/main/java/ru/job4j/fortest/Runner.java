package ru.job4j.fortest;

public class Runner {
    public static void main(String[] args) {

        int x = 1234599999;
        System.out.println(reverse(x));

    }

    public static int reverse(int x) {
        int rsl = 0;
        while (x !=0) {
            int pop = x % 10;
            x /= 10;
            if (rsl > Integer.MAX_VALUE / 10 || rsl == Integer.MAX_VALUE / 10 && pop > 7) {
                return 0;
            }
            if (rsl < Integer.MIN_VALUE / 10 || rsl == Integer.MIN_VALUE / 10 && pop < -8) {
                return 0;
            }
            rsl = rsl * 10 + pop;
        }

        return rsl;
    }
}

