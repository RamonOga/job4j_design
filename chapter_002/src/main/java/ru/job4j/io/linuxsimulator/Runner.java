package ru.job4j.io.linuxsimulator;

public class Runner {
    public static void main(String[] args) {
        IO io = IO.getIO();
        io.greeting();
        io.scan();

    }
}
