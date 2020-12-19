package ru.job4j.io;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Runner {
    public static void main(String[] args) {
        Format f = new SimpleDateFormat("hh:mm:ss a");
        String strResult = f.format(new Date());
        System.out.println(strResult);
        System.out.println(new Date());
    }
}
