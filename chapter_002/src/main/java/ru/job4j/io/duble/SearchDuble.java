package ru.job4j.io.duble;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class SearchDuble {

    public static void main(String[] args) throws IOException {
        Path start = Paths.get("C:\\projects\\job4j_design\\chapter_002\\data\\test");
        SearchDubleVisitor searcher = new SearchDubleVisitor();
        Files.walkFileTree(start, searcher);
        searcher.createDubleMap();
        searcher.printDuble();
    }
}
