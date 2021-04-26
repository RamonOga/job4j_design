package ru.job4j.solid.lsp.productStorage;

import org.junit.Test;
import ru.job4j.solid.lsp.productStorage.foods.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ShopTest {

    @Test
    public void whenAddToTrash() {
        Calendar created = Calendar.getInstance();
        created.add(Calendar.DATE, -100);
        Calendar expiry = Calendar.getInstance();
        expiry.add(Calendar.DATE, -1);

        List<Storage> storageList = List.of(new Trash());
        ControlQuality controlQuality = new ControlQuality(storageList);
        controlQuality.addFood(new Chocolate("Chocolate", created.getTime(), expiry.getTime(), 1000));
    }


    @Test
    public void whenAddToShop() {
    }

    @Test
    public void whenAddToShopWithDiscount() {
    }

    @Test
    public void whenAddToWH() {
    }


    @Test
    public void accept() {
    }
}
/*

    List<Food> foodList = List.of(new Chocolate("Ch", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), 1000),
            new Bread("Br", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), 1001),
            new Milk("Ml", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), 1002),
            new Meat("Mt", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), 1003));*/
