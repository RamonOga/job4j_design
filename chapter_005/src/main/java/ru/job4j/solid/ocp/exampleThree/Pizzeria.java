package ru.job4j.solid.ocp.examplethree;

import java.util.ArrayList;
import java.util.List;

public class Pizzeria {
    private final String name;
    private List<Product> productList;

    public Pizzeria(String name) {
        this.name = name;
        productList = new ArrayList<>();
    }

    public void addProducts(Product product) {
        productList.add(product);
    }

    public void createThreeCheesePizza() {
        for (Product p : productList) {
            if (p.getClass() == Cheese.class) {
                p.addInPizza(1);
            }
        }
        System.out.println("Pizza created");
    }
}
