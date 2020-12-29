package ru.job4j.io.duble;

import java.util.*;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class SearchDubleVisitor implements FileVisitor<Path> {

    private Map<FileDubleData, List<Path>> dataMap = new HashMap<>();

    public Map<FileDubleData, List<Path>> getDataMap() {
        return dataMap;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileDubleData tmp = new FileDubleData(file);
        if (dataMap.get(tmp) == null) {
            List<Path> list = new ArrayList<>();
            list.add(file);
            dataMap.put(tmp, list);
        } else {
            dataMap.get(tmp).add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}
