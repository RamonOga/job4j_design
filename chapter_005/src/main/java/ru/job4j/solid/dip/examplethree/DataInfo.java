package ru.job4j.solid.dip.examplethree;

import java.util.List;
import java.util.PrimitiveIterator;

public class DataInfo {
    private String name;
    private int id;
    private List<String> dataList;

    public DataInfo(String name, int id, List<String> dataList) {
        this.name = name;
        this.id = id;
        this.dataList = dataList;
    }

    public List<String> getDataList() {
        return dataList;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
