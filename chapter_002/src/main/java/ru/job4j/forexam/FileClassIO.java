package ru.job4j.forexam;

import java.io.File;
import java.io.IOException;

public class FileClassIO {
    public static void main(String[] args) throws IOException {
        File file = new File("d:/1c_bases/retail/123312");

        file.isDirectory();
        file.isAbsolute();
        file.getName();
        file.getParent();
        file.getPath();

        file.exists();
        file.canRead();
        file.length();
        file.isFile();
        file.lastModified();
        file.list();
        file.listFiles();

        file.createNewFile();
        file.delete();
        file.renameTo(new File("f:/"));
        file.mkdir();
        file.mkdir();
    }
}
