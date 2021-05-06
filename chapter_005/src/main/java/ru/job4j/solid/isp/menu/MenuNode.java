package ru.job4j.solid.isp.menu;

import java.awt.*;
import java.util.List;

public class MenuNode {

    private String menuName;

    public List<MenuNode> getChildren() {
        return children;
    }

    private List<MenuNode> children;

    public String getMenuName() {
        return menuName;
    }

    public MenuNode(String menuName, List<MenuNode> childrens) {
        this.menuName = menuName;
        this.children = childrens;
    }

    public MenuNode(String menuName) {
        this.menuName = menuName;
    }

    public void printMenu() {
        System.out.println("menu name: " + menuName);
        System.out.println(children);
    }

    private String getChildrenNames() {
        String rsl = "";
        for (MenuNode menuNode : children) {

        }
        return rsl;
    }

    @Override
    public String toString() {
        String rsl = "Menu Name : " + menuName + "\n";
        if (children != null) {
            for (MenuNode menuNode : children) {
                rsl += menuNode.toString();
            }
        }
         return rsl;
    }
}
