package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilterReader;
import java.util.*;
import java.util.stream.Collectors;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        List<String> list = null;
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
                list = read.lines()
                        .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list != null) {
            for (String s : list) {
                String[] tmp = s.split("=");
                if (tmp.length != 2) {
                    continue;
                }
                this.values.put(tmp[0], tmp[1]);
            }
        }
        System.out.println(values);
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
        //System.out.println(conf.toString());
        conf.load();
    }
}