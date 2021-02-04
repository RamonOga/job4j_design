package ru.job4j.io.linuxsimulator;

public class Runner {
    public static void main(String[] args) {
        IO io = IO.createIO();
        io.greeting();
        io.scan();
    }
}
