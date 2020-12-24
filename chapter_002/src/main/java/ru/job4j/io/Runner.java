package ru.job4j.io;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class Runner {
    public static void main(String[] args) {
        Path p = Paths.get(".");
        Iterator<Path> it = p.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
