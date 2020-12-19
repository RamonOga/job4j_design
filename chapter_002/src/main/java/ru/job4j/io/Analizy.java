package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> list = null;
        StringJoiner joiner = new StringJoiner("");
        int count = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            list = in.lines()
                    .filter(a -> a.length() > 0)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list != null) {
            for (String s : list) {
                if (count == 0 && (s.contains("400") || s.contains("500"))) {
                    joiner.add(s.split(" ")[1] + ";");
                    count++;
                    continue;
                }
                if (count == 1 && (s.contains("200") || s.contains("300"))) {
                    joiner.add(s.split(" ")[1] + System.lineSeparator());
                    count = 0;
                }
            }
        }
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            out.write(joiner.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Analizy anal = new Analizy();
        anal.unavailable("./chapter_002/data/server.log", "./chapter_002/data/ShutdownsLog.log");
    }
}