package ru.job4j.leetcode;

public class NumberComplement {
    public static void main(String[] args) {
        System.out.println(binaryNumber(1));
        System.out.println(binaryNumber(2));
        System.out.println(binaryNumber(5));
        System.out.println(binaryNumber(256));
        System.out.println(findComplement(1));
        System.out.println(findComplement(2));
        System.out.println(findComplement(5));
        System.out.println(findComplement(256));
    }


    public static int findComplement(int num) {
        StringBuilder sb = new StringBuilder();
        int rsl = 0;
        int count = 0;
        while (num != 0) {
            rsl += Math.pow(2, count) * binaryReverse(num % 2);
            count++;
            num /= 2;
        }

        return rsl;
    }

    private static int binaryReverse(int bi) {
        if (bi > 1 || bi < 0) {
            throw new IllegalArgumentException("");
        }
        if (bi == 1) {
            return 0;
        } else {
            return 1;
        }
    }

    public static String binaryNumber(int num) {
        StringBuilder rsl = new StringBuilder();
        while (num != 0) {
            rsl.append(num % 2);
            num /= 2;
        }
        return (rsl.reverse().toString());
    }
}
