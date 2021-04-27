package ru.job4j.solid.lsp.productstorage.foods;

import java.util.Date;

public class Milk extends Food {
    public Milk(String name, Date expiryDate, Date createDate, int price) {
        super(name, expiryDate, createDate, price);
    }
}
