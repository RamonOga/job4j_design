package ru.job4j.solid.srp.exampleTwo;

import java.util.List;

public interface IShop {

    boolean addItem(Item item);
    List<Item> getItemPrice();
    void returnItem(Item item, Person person);
    void buy(Item item, Person person);
}
