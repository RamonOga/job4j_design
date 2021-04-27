package ru.job4j.leetcode;

public class MergeStringsAlternately {
    public static void main(String[] args) {

    }

    public String mergeAlternately(String word1, String word2) {
        int minSize = Math.min(word1.length(), word2.length());
        String hlp = word1.length() > word2.length() ? word1 : word2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minSize; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        for (int i = minSize; i < hlp.length(); i++) {
            sb.append(hlp.charAt(i));
        }
        return sb.toString();
    }
}
