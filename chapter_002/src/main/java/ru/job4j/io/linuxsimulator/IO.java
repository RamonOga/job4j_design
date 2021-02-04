package ru.job4j.io.linuxsimulator;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IO {
    private Scanner scan = new Scanner(System.in);
    private final HashSet<String> commands = new HashSet<>(Set.of("cd", "ls"));
    private final String exit = "exit";

    private IO() {
    }

    public static IO createIO() {
        return new IO();
    }

    public String scan(String s) {
       String rsl = scan.nextLine();
       while (true) {
           if (commands.contains(rsl)) {
               return rsl;
           } else {
               System.out.println("Command not found.");
               rsl = scan.nextLine();
           }
       }
    }

    public void greeting() {
        System.out.println("Welcome to my Linux Command Line Simulator");
        System.out.println("Please enter your command:");
    }
}
