package ru.job4j.io.duble;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchDuble {

    public static void main(String[] args) throws IOException {
        Path start = Paths.get("C:\\projects\\job4j_design\\chapter_002\\data\\test");
        Map<FileDubleData, List<Path>> map = search(start);
         for (FileDubleData fileData : map.keySet()) {
             if (map.get(fileData).size() > 1) {
                 System.out.println(map.get(fileData));
             }
         }
    }

    public static Map<FileDubleData, List<Path>> search(Path root) throws IOException {
        SearchDubleVisitor searcher = new SearchDubleVisitor();
        Files.walkFileTree(root, searcher);
        return searcher.getDataMap();
    }
}
