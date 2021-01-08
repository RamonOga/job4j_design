package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Runner {
    public static void main(String[] args) throws IOException {
        File f1 = new File("C:\\projects\\job4j_design\\chapter_002\\data\\test\\file 1.txt");
        System.out.println(f1.toPath());
        System.out.println(f1.toPath().endsWith("txt"));
        System.out.println(f1.toPath().toString().endsWith("txt"));
    }
}
