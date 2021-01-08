package ru.job4j.io.chatbot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Runner {
    private final String out = "закончить";
    private final String active = "продолжить";
    private final String pause = "стоп";
    private boolean checkPause = true;
    private List<String> logsList = new ArrayList<>();

    public void run() {

        IO io = new IO();
        List<String> answersList = io.getAnswers();
        Random random = new Random();
        UserInterface inter = new UserInterface();
        String text = inter.scanUserData();

        inter.sayHello();
        while (!text.equals(out)) {
            String answer = answersList
                    .get(random.nextInt(answersList.size() -  1));
            checkMute(text);
            if (checkPause) {
                System.out.println(answer);
                saveLogs(answer);
            }
            saveLogs(text);
            text = inter.scanUserData();

        }
        io.writeFile(logsList);
    }

    public void checkMute(String input) {

        if (input.equals(pause)) {
            checkPause = false;
        }

        if (input.equals(active)) {
            checkPause = true;
        }
    }

    public void saveLogs(String log) {
        logsList.add(log);
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.run();
    }
}
