package ru.job4j.solid.isp.menu;

public interface Menu {

    void add(Item parent, Item children);
    Item get(String name);
    String print();
}
