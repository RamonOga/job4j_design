package ru.job4j.io.linuxsimulator;

import java.util.Stack;
import java.util.StringJoiner;

public class ShallPath {
    Stack<String> stack = new Stack<>();

    public void push(String input) { stack.push(input);
    }

    public void pop() {
        stack.pop();
    }

    public String print() {
        StringJoiner sj = new StringJoiner("/", "/", "");
        for (String s : stack) {
            sj.add(s);
        }
        System.out.println(sj);
        return sj.toString();
    }
}
