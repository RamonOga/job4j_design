package ru.job4j.solid.lsp.productstorage.foods;

import java.util.Date;

public class Chocolate extends Food {
    public Chocolate(String name, Date expiryDate, Date createDate, int price) {
        super(name, expiryDate, createDate, price);
    }
}
