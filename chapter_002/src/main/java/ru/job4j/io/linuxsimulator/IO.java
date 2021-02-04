package ru.job4j.io.linuxsimulator;

import java.util.Scanner;

public class IO {
    private Scanner scan = new Scanner(System.in);
    private static IO io;

    private IO() {
    }

    public static IO getIO() {
        if (io == null) {
            io = new IO();
        }
        return io;
    }

    public String scan() {
       return scan.nextLine();
    }

    public void greeting() {
        System.out.println("Welcome to my Linux Command Line Simulator");
        System.out.println("Please enter your command:");
    }
}
