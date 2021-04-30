package ru.job4j.leetcode;

import java.util.Stack;

public class RemoveDuplicates {
    public static String removeDuplicates(String S) {
        String[] arr = S.split("");
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for (String s : arr) {
            if (stack.isEmpty() || !stack.peek().equals(s)) {
                stack.push(s);
            } else {
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
