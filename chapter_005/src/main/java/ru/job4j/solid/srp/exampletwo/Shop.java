package ru.job4j.solid.srp.exampletwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop implements IShop {

    List<Item> itemList;
    Map<Person, List<Item>> buysList;

    public Shop() {
        this.itemList = new ArrayList<>();
        this.buysList = new HashMap<>();
    }

    @Override
    public boolean addItem(Item item) {
        return itemList.add(item);
    }

    @Override
    public List<Item> getItemPrice() {
        if (itemList == null) {
            throw new IllegalArgumentException("List is empty");
        }
        return itemList;
    }

    @Override
    public void returnItem(Item item, Person person) {
        if (!buysList.containsKey(person)) {
            throw new IllegalArgumentException("This person not found");
        }
        List<Item> list = buysList.get(person);
        list.remove(item);
    }

    @Override
    public void buy(Item item, Person person) {
        if (!buysList.containsKey(person)) {
            List<Item> newList = new ArrayList<>();
            newList.add(item);
            buysList.put(person, newList);
        }
        List<Item> list = buysList.get(person);
        list.add(item);
    }
}
