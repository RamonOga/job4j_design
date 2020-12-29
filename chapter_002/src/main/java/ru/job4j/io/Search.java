package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Enter root folder and file extensions for search and.");
        }
        Path start = Paths.get(args[0]);
        search(start, args[1]).forEach(System.out::println);
    }

    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}