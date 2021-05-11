package ru.job4j.solid.isp.menu;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Action action = new SimpleAction();
        Item item1 = new Item("1", action);
        Item item11 = new Item("1.1", action);
        Item item12 = new Item("1.2", action);
        Item item121 = new Item("1.2.1", action);
        Item item1211 = new Item("1.2.1.1", action);
        Item item13 = new Item("1.3", action);
        Item item2 = new Item("2", action);
        Item item21 = new Item("1.2", action);
        Menu menu = new MenuStorage();
        menu.add(null, item1);
        menu.add(item1, item11);
        menu.add(item1, item12);
        menu.add(item12, item121);
        menu.add(item121, item1211);
        menu.add(item1, item13);
        menu.add(null, item2);
        menu.add(item2, item21);
        System.out.println(menu.print());


    }
}
