package ru.job4j.solid.lsp.productStorage;

import ru.job4j.solid.lsp.productStorage.foods.Food;
import java.util.List;

public class ControlQuality {
    private Shop shop;
    private Trash trash;
    private Warehouse wh;

    public ControlQuality(Shop shop,Warehouse wh, Trash trash) {
        if (shop == null || trash == null || wh == null) {
            throw new IllegalArgumentException("One of the arguments equal null");
        }
        this.shop = shop;
        this.trash = trash;
        this.wh = wh;
    }

    public Shop getShop() {
        return shop;
    }

    public Trash getTrash() {
        return trash;
    }

    public Warehouse getWh() {
        return wh;
    }

    public void redistribute(List<Food> foodList) {
        for (Food food : foodList) {
            if (food.getExpiryDate().getTime() - food.getCreateDate().getTime() > 300000) {
                shop.foodStorage.add(food);
            }
            if (food.getExpiryDate().getTime() - food.getCreateDate().getTime() > 600000) {
                wh.foodStorage.add(food);
            }
            if (food.getExpiryDate().getTime() - food.getCreateDate().getTime() > 900000) {
                food.setDiscount(true);
                trash.foodStorage.add(food);
            }
            if (food.getExpiryDate().getTime() - food.getCreateDate().getTime() > 1200000) {
                trash.foodStorage.add(food);
            }
        }
    }
}
