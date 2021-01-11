package ru.job4j.io.archive;

public class ArgZip {

    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        return args.length == 3;
    }

    public String directory() {
        return args[0]
                .subSequence(3, args[0].length())
                .toString();
    }

    public String exclude() {
        return args[1]
                .subSequence(3, args[1].length())
                .toString();

    }

    public String output() {
        return args[2]
                .subSequence(3, args[2].length())
                .toString();
    }

    public String getLastFolder() {
        String[] array = directory().split("\\\\");
        return array[array.length - 1];
    }
}