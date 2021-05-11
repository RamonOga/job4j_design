package ru.job4j.solid.isp.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Item {

    private Action action;
    private String name;
    private List<Item> children;

    public Item(String menuName, Action action) {
        this.action = action;
        this.name = menuName;
        children = new ArrayList<>();
    }

    public void act() {
        action.act();
    }

    public Item findBuName(String name) { // здесь можно использовать nullItem вместо null;
        Stack<Item> itemStack = new Stack<>();
        Item rsl = null;
        itemStack.push(this);
        while (!itemStack.isEmpty()) {
            Item current = itemStack.pop();
            if (current.getName().equals(name)) {
                rsl = current;
                break;
            }
            if (current.getChildren() != null) {
                for (Item childrenItem : current.getChildren()) {
                    childrenItem.findBuName(name);
                }
            }
        }
        return rsl;
    }

    public Action getAction() {
        return action;
    }

    public List<Item> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public Item(String menuName) {
        this.name = menuName;
    }



    @Override
    public String toString() {
        String rsl = "Menu Name : " + name + "\n";
        if (children != null) {
            for (Item menuNode : children) {
                rsl += menuNode.toString();
            }
        }
         return rsl;
    }
}
