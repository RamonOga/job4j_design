package ru.job4j.solid.lsp.productStorage;

import ru.job4j.solid.lsp.productStorage.foods.*;

import java.sql.Connection;
import java.util.Calendar;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Warehouse wh = new Warehouse();
        Trash trash = new Trash();
        List<Food> foodList = List.of(new Chocolate("Ch", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), 1000),
                new Bread("Br", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), 1001),
                new Milk("Ml", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), 1002),
                new Meat("Mt", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), 1003));

        ControlQuality controlQuality = new ControlQuality(shop, wh, trash);
        controlQuality.redistribute(foodList);
    }
}
