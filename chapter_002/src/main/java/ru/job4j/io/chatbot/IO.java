package ru.job4j.io.chatbot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.io.logs.UsageLog4j;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class IO {
    final static private Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());
    final private String answersPath = ".\\chapter_002\\src\\main\\java\\ru\\job4j\\io\\chatbot\\data\\answers.txt";
    final private String logsPath = ".\\chapter_002\\src\\main\\java\\ru\\job4j\\io\\chatbot\\data\\logs.txt";

    public List<String> getAnswers() {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(answersPath))) {
            String line = in.readLine();
            while (line != null) {
                rsl.add(line);
                line = in.readLine();
            }
        } catch (Exception e) {
            LOG.error("File not found.", e);
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
            LOG.error("File not found.", e);
        }
    }
}
