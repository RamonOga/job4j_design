package ru.job4j.io;

import java.io.FileOutputStream;

public class FileOutStream {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        for (int x = 1; x < 10; x++) {
            for (int y = 1; y < 10; y++) {
                    s.append(x)
                            .append(" * ").append(y).append(" = ")
                            .append(x * y).append(System.lineSeparator());
            }
        }
        try (java.io.FileOutputStream out = new java.io.FileOutputStream("TableMultiplication.txt")) {
            out.write(s.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}