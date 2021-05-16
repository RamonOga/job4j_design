package ru.job4j.solid.lsp.productstorage.foods;

import java.util.Date;
import java.util.Objects;

public class Food {
    private String name;
    private Date expiryDate;
    private Date createDate;
    private int price;
    private boolean discount;

    public Food(String name, Date createDate, Date expiryDate, int price) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return price == food.price &&
                discount == food.discount &&
                Objects.equals(name, food.name) &&
                Objects.equals(expiryDate, food.expiryDate) &&
                Objects.equals(createDate, food.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expiryDate, createDate, price, discount);
    }
}
