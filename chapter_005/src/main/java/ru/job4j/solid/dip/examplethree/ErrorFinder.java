package ru.job4j.solid.dip.examplethree;

import java.util.ArrayList;
import java.util.List;

public class ErrorFinder {

    public void errorFind(DataInfo info) {
        List<String> list = info.getDataList();
        for (String s : list) {
            if (s.toLowerCase().contains("error")) {
                System.out.println(s);
            }
        }
    }

}
