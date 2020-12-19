package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        List<String[]> list = null;
        final String[] b = {};
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            list = read.lines()
                    .filter(a -> a.length() > 0 && !a.contains("#"))
                    .map((a) -> a.split("="))
                    .filter(a -> a.length == 2 && (a[0] != null && a[1] != null))
                    .peek(a -> values.put(a[0], a[1]))
            .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        String rsl = values.get(key);
        if (rsl == null) {
            throw new NullPointerException("Key must not by null!");
        }
        return rsl;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config conf = new Config("./chapter_002/data/pair_without_comment.properties");
        conf.load();
        System.out.println(">>>>" + conf.values);
        System.out.println(">>>>" + conf.values.get("name4"));

    }
}