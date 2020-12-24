package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> list = new ArrayList<>();
        
        int count = 0;
        StringBuilder text = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            String s = in.readLine();
            while (s != null) {
                if (count == 0 && (s.contains("400") || s.contains("500"))) {
                    text.append(s.split(" ")[1]).append(";");
                    count++;
                }
                if (count == 1  && (s.contains("200") || s.contains("300"))) {
                    text.append(s.split(" ")[1]).append(System.lineSeparator());
                    count = 0;
                    list.add(text.toString());
                    text.delete(0, text.length());
                }
                s = in.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (String s : list) {
                out.write(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}