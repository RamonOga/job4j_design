package ru.job4j.solid.lsp.productstorage.foods;

import java.util.Date;

public class Meat extends Food {
    public Meat(String name, Date expiryDate, Date createDate, int price) {
        super(name, expiryDate, createDate, price);
    }
}
