package ru.job4j.solid.dip.examplethree;

import java.util.List;

public class ErrorFinder {

    public void errorFind(Info info) {
        List<String> list = info.getDataList();
        for (String s : list) {
            if (s.toLowerCase().contains("error")) {
                System.out.println(s);
            }
        }
    }

}
