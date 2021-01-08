package ru.job4j.io.chatbot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class IO {
    final private String answersPath = "C:\\projects\\job4j_design\\chapter_002\\src\\main\\java\\ru\\job4j\\io\\chatbot\\data\\answers.txt";
    final private String logsPath = "C:\\projects\\job4j_design\\chapter_002\\src\\main\\java\\ru\\job4j\\io\\chatbot\\data\\logs.txt";

    public List<String> getAnswers() {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(answersPath))) {
            String line = in.readLine();
            while (line != null) {
                rsl.add(line);
                line = in.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public void writeFile(List<String> data) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(logsPath))) {
            for (String s : data) {
                out.write(s);
                out.write(System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
