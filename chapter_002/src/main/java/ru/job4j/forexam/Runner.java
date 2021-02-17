package ru.job4j.forexam;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) throws IOException {
        Path p = Paths.get("log.txt");
        Stream<String> stream =  Files.lines(p);
        stream.forEach(System.out::println);
    }
}
