package ru.job4j.solid.isp.menu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        MenuNode head = new MenuNode("1",
                List.of( new MenuNode("1.1",
                        List.of(new MenuNode("1.1.1"), new MenuNode("1.1.2"))
                ), new MenuNode("1.2")));

        System.out.println(head);
    }
}
