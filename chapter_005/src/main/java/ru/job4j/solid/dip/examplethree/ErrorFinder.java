package ru.job4j.solid.dip.examplethree;

import java.util.ArrayList;
import java.util.List;

public class ErrorFinder {
    List<String> errorList;

    public ErrorFinder() {
        this.errorList = new ArrayList<>();
    }

    public void errorFind(DataInfo info) {
        List<String> list = info.getDataList();
        for (String s : list) {
            if (s.toLowerCase().contains("error")) {
                errorList.add(s);
            }
        }
    }

}
