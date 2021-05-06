package ru.job4j.solid.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        MenuNode head = new MenuNode("1",
                List.of( new MenuNode("1.1",
                        List.of(new MenuNode("1.1.1"), new MenuNode("1.1.2"))
                ), new MenuNode("1.2")));

        System.out.println(head);
    }
}
