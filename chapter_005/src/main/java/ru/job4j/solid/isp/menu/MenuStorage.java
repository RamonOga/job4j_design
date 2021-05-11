package ru.job4j.solid.isp.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class MenuStorage implements Menu {
    private List<Item> rootList;

    public MenuStorage() {
        this.rootList = new ArrayList<>();
    }


    @Override
    public void add(Item parent, Item children) { // что делать, если не нашли родителя?
        if (parent == null) {
            rootList.add(children);
        } else {
            this.get(parent
                    .getName())
                    .getChildren()
                    .add(children);
        }
    }

    @Override
    public Item get(String name) {
        Item rsl = null;
        for (Item rootItem : rootList) {
            rsl = rootItem.findBuName(name);
        }
        if (rsl == null) {
            throw new NoSuchElementException("Item no found");
        }
        return rsl;
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        for (Item item : rootList) {
            sb.append(item.toString());
        }
        return sb.toString();
    }
}
