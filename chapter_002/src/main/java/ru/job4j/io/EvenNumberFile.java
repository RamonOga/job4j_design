package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            String[] array;
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            array = text.toString().split(System.lineSeparator());
            for (String s : array) {
                System.out.println(Integer.parseInt(s) % 2 == 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
