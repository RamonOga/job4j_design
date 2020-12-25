package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class SearchDublicateFiles implements FileVisitor<Path> {

    private List<Path> list;
    private Map<Path, String> pathsMap;
    private Map<String, Long> checkMap;

    public SearchDublicateFiles() {
        list = new ArrayList<>();
        pathsMap = new HashMap<>();
        checkMap = new HashMap<>();
    }


    public List<Path> getPaths() {
        return list;
    }

    public Map<String, Long> getCheckMap() {
        return checkMap;
    }

    public Map<Path, String> getMapPaths() {
        return pathsMap;
    }


    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Long l  = checkMap.put(file.getFileName().toString(),
                file.toFile().length());
        if (l != null && checkMap.get(file.getFileName().toString()).
                            equals(file.toFile().length())) {


        }
        //pathsMap.put(file, file.toAbsolutePath().toString());
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