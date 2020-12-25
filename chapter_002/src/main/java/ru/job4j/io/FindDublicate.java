package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class FindDublicate {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get("D:\\test");
        System.out.println(search(start));

    }

    public static Map<Path, String> search(Path root) throws IOException {
        SearchDublicateFiles searcher = new SearchDublicateFiles();
        Files.walkFileTree(root, searcher);
        return searcher.getMapPaths();
    }
}
