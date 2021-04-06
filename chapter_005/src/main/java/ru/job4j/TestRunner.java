package ru.job4j;

public class TestRunner {
    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(676));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(2147483647));
        System.out.println(convertToTitle(1));

        }

    public static String convertToTitle(int columnNumber) {
        String rsl = "";
        while (columnNumber / 26 > 0) {
            rsl += getWord(columnNumber % 26);
            columnNumber /= 26;
        }
        rsl += getWord(columnNumber % 26);
        return rsl;
    }

    private static String getWord(int columnNumber) {
        if (columnNumber == 0) {
            return "";
        }
        final int upLimit = 64;
        char c = (char) (upLimit + columnNumber);
        String rsl = String.valueOf(c);
        return rsl;
    }
}
