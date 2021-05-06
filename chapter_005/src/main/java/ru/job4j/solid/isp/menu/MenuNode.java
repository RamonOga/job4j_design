package ru.job4j.solid.isp.menu;

import java.util.List;

public class MenuNode {

    private String menuName;
    private List<MenuNode> children;

    public MenuNode(String menuName, List<MenuNode> childrens) {
        this.menuName = menuName;
        this.children = childrens;
    }

    public MenuNode(String menuName) {
        this.menuName = menuName;
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
