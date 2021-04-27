package ru.job4j.solid.srp.exampletwo;

public class Item implements IItem {
    int id;
    int price;
    String name;

    public Item(int id, int price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void applyDiscount(float dis) {
        price = (int) (price * dis);
    }
}
