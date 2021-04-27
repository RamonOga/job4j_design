package ru.job4j.solid.lsp.productstorage;

import org.apache.commons.math3.ode.nonstiff.ThreeEighthesIntegrator;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.solid.lsp.productstorage.foods.*;
import ru.job4j.solid.ocp.examplethree.Cheese;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class ShopTest {


    @Test
    public void whenAddToWH() {
        Calendar created = Calendar.getInstance();
        Calendar expiry = Calendar.getInstance();
        expiry.add(Calendar.DATE, 95);
        Food milk = new Milk("Milk", created.getTime(), expiry.getTime(), 1000);
        ControlQuality controlQualityT = new ControlQuality(List.of(new Trash()));
        ControlQuality controlQualityS = new ControlQuality(List.of(new Shop()));
        ControlQuality controlQualityW = new ControlQuality(List.of(new Warehouse()));
        boolean rsl = controlQualityT.addFood(milk);
        System.out.println(rsl);
        assertFalse(rsl);
        rsl = controlQualityS.addFood(milk);
        System.out.println(rsl);
        assertFalse(rsl);
        rsl = controlQualityW.addFood(milk);
        System.out.println(rsl);
        assertTrue(rsl);
    }

    @Test
    public void whenAddToShop() {
            Calendar created = Calendar.getInstance();
            created.add(Calendar.DATE, -30);
            Calendar expiry = Calendar.getInstance();
            expiry.add(Calendar.DATE, 70);
            Food choc = new Chocolate("Chocolate", created.getTime(), expiry.getTime(), 1000);
            ControlQuality controlQualityT = new ControlQuality(List.of(new Trash()));
            ControlQuality controlQualityS = new ControlQuality(List.of(new Shop()));
            ControlQuality controlQualityW = new ControlQuality(List.of(new Warehouse()));
            assertFalse(controlQualityT.addFood(choc));
            assertTrue(controlQualityS.addFood(choc));
            assertFalse(controlQualityW.addFood(choc));
        }

    @Test
    public void whenAddToShopWithDiscount() {
        Calendar created = Calendar.getInstance();
        created.add(Calendar.DATE, -80);
        Calendar expiry = Calendar.getInstance();
        expiry.add(Calendar.DATE, 20);
        Food choc = new Chocolate("Chocolate", created.getTime(), expiry.getTime(), 1000);
        ControlQuality controlQualityT = new ControlQuality(List.of(new Trash()));
        ControlQuality controlQualityS = new ControlQuality(List.of(new Shop()));
        ControlQuality controlQualityW = new ControlQuality(List.of(new Warehouse()));
        assertFalse(controlQualityT.addFood(choc));
        assertTrue(controlQualityS.addFood(choc));
        assertFalse(controlQualityW.addFood(choc));
        assertTrue(choc.isDiscount());
    }

    @Test
    public void whenAddToTrash() throws InterruptedException {
        Calendar creat = Calendar.getInstance();
        creat.add(Calendar.DATE, -100);
        Calendar exp = Calendar.getInstance();
        exp.add(Calendar.DATE, -1);
        Food choc = new Chocolate("Chocolate", creat.getTime(), exp.getTime(), 1000);

        ControlQuality controlQualityTr = new ControlQuality(List.of(new Trash()));
        ControlQuality controlQualitySh = new ControlQuality(List.of(new Shop()));
        ControlQuality controlQualityWh = new ControlQuality(List.of(new Warehouse()));

        assertTrue(controlQualityTr.addFood(choc));
        assertFalse(controlQualitySh.addFood(choc));
        assertFalse(controlQualityWh.addFood(choc));
    }
}
