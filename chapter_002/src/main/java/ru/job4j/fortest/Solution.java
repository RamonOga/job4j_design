package ru.job4j.fortest;


import java.util.*;

class Solution {
    /**
     * Implement method buildTower
     */
    public static List<String> buildTower(int n) {
        List<String> rsl = new ArrayList<>();
        StringBuffer tmp = new StringBuffer();
        int width = (n * 2) - 1;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < (n*2) - 1; i++) {
                if ((width - n) == i || (((width - n) - j ) == i) || (((width - n) + j) == i)) {
                    tmp.append("*");
                } else {
                    tmp.append(" ");
                }
            }
            rsl.add(tmp.toString());
            tmp.delete(0, tmp.length());
        }
        return rsl;
    }

    public static void runCode() {
        List<String> list = buildTower(5);
        for (String s : list) {
            System.out.println("|" + s + "|");
        }
    }
}