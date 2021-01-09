package ru.job4j.io.socket;

public class ServerAnswer {
    private final String hello = "Hello";
    private final String exit = "Exit";
    private final String what = "What";

    public String answer(String inquiry) {
        String rsl = what;
        if (inquiry.contains(hello)) {
           rsl = "Hello";
        }
        return rsl;
    }

    public boolean checkExit(String inquiry) {
        return !inquiry.contains(exit);
    }
}
