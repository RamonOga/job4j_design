package ru.job4j.io.linuxsimulator;

import java.util.Scanner;

public class IO {
    private final Scanner scan = new Scanner(System.in);
    private static IO io;

    private IO() {
    }

    public static IO getIO() {
        if (io == null) {
            io = new IO();
        }
        return io;
    }

    public String[] scan() {
       return splitInput(scan.nextLine());
    }

    private String[] splitInput(String command) {
        String[] rsl = new String[]{"", ""};
        if (command != null) {
            String[] tmp = command.split(" ");
            if (tmp.length == 2) {
                rsl = tmp;
            } else {
                rsl[0] = tmp[0];
            }
        }
        return rsl;
    }

    public void greeting() {
        System.out.println("Welcome to my Linux Command Line Simulator");
        System.out.println("Please enter your command:");
    }
}
