package ru.job4j.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.StringJoiner;

import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void unavailableTest() {
        Analizy anal = new Analizy();
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        String expected1 = "10:57:01;10:59:01";
        String expected2 = "11:01:02;11:02:02";
        anal.unavailable("C:/projects/job4j_design/chapter_002/data/server.log",
                "C:/projects/job4j_design/chapter_002/data/ShutdownsLog.log");
        try (BufferedReader in = new BufferedReader
                (new FileReader
                        ("C:/projects/job4j_design/chapter_002/data/ShutdownsLog.log"))) {
            String line = in.readLine();
            while ( line != null) {
                joiner.add(line);
                line = in.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(joiner.toString().contains(expected1));
        Assert.assertTrue(joiner.toString().contains(expected2));
    }

}