package ru.job4j.io.linuxsimulator;

import java.util.HashSet;
import java.util.Set;

public class Validate {
    private static final Validate VAL = new Validate();
    private final HashSet<String> commands = new HashSet<>(Set.of("cd", "ls"));
    private final String exit = "exit";

    private Validate() {
    }

    public Validate getValidate() {
        return VAL;
    }


    public boolean checkCommand(String command) {
        String[] input = command.split(" ");
        if (input.length != 2 || !command.equals(input[0])) {
            return false;
        }
        return true;
    }
}
