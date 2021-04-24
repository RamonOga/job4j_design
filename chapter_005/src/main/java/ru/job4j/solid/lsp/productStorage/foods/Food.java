package ru.job4j.solid.lsp.productStorage.foods;

import java.util.Date;

public class Food {
    private String name;
    private Date expiryDate;
    private Date createDate;
    private int price;
    private boolean discount;

    public Food(String name, Date expiryDate, Date createDate, int price) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = false;
    }

    public String getName() {
        return name;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public int getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }
}
