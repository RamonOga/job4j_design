package ru.job4j.leetcode;

import org.apache.commons.collections.map.HashedMap;

import java.util.HashMap;
import java.util.Map;
//input String s = "AAABCZ";
//output String s = "A3BCZ";
public class RepeatingInString {

    public static void main(String[] args) {

        System.out.println(method1("AAABBCCCA"));
    }


    public static String method1(String input) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for (String s : input.split("")) {
            if (map.containsKey(s)) {
                map.replace(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        for (String s : map.keySet()) {
            Integer i = map.get(s);
            if (i != 1) {
                sb.append(s);
                sb.append(i);
            } else {
                sb.append(s);
            }
        }
        return sb.toString();
    }
}
