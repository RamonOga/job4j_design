package ru.job4j.io.archive;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws IOException {
        ArgZip argZip = new ArgZip(args);
        if (!argZip.valid()) {
            throw new IllegalArgumentException("Enter arguments, pls!");
        }
        ZipVisitor visitor = new ZipVisitor(argZip.exclude());
        Zip zip = new Zip();
        Files.walkFileTree(Path.of(argZip.directory()), visitor);
        List<File> listFiles = visitor.getFilesList();
        zip.packFiles(listFiles, new File(argZip.directory()
                        + "\\" + argZip.output()), argZip.getLastFolder());
    }
}
