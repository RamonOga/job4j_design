package ru.job4j.jdbc;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class Runner {
    public static void main(String[] args) {
        String s = "don't";
        s = s.replace("'", ".");
        System.out.println(s);
    }
}
