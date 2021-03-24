package ru.job4j.gc.cache;

import java.io.*;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class SoftCache {
    Map<String, SoftReference<String>> cache = new HashMap<>();
    private static final String directory = "./chapter_004/src/resources/";

    public String getData(String file) {
        SoftReference<String> refContents = cache.get(file);
        if (refContents == null) {
            refContents = new SoftReference<>(readFile(file));
            cache.put(file, refContents);
        }
        System.out.println(cache.size());
        return refContents.get();
    }

    private String readFile(String file) {
        StringJoiner sj = null;
        try(BufferedReader bis = new BufferedReader(new FileReader(directory + file))) {
            sj = new StringJoiner(System.lineSeparator());
                bis.lines().forEach(sj::add);
        } catch (IOException ioe) {
            ioe.fillInStackTrace();
        }
        if (sj != null) {
            return sj.toString();
        } else {
            throw new IllegalArgumentException("File not found");
        }
    }
}
