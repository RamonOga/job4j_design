package ru.job4j.forexam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathClassNIO {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("d:/1c_bases/retail/12321");

        path.isAbsolute();
        path.getFileName();
        path.getParent();
        path.getNameCount();
        path.getName(1);

        Files.exists(path);
        Files.isRegularFile(path);
        Files.isReadable(path);
        Files.size(path);
        Files.delete(path);
        Files.move(path, Paths.get("C:/"));
        Files.copy(path, Paths.get("C:/"));

    }
}
