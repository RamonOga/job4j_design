package ru.job4j.io.socket;

public class ServerAnswer {
    private final String hello = "Hello";
    private final String exit = "Exit";
    private final String msg = "msg";
    private String answer;
    private boolean checkExit = true;

    public void answer(String inquiry) {
        answer = "What";
        for (String s : inquiry.split(System.lineSeparator())) {
            if (s.contains(msg)) {
                String rsl = s.split("=")[1];
                if (rsl.contains(hello)) {
                    answer = hello;
                } else if (rsl.contains(exit)) {
                    checkExit = false;
                    break;
                }
            }
        }
    }

    public boolean getCheckExit() {
        return checkExit;
    }

    public String getAnswer() {
        return answer;
    }
}
