package ru.job4j.solid.lsp.productStorage;

import ru.job4j.solid.lsp.productStorage.foods.Food;
import java.util.List;

public class ControlQuality {
    private List<Storage> storageList;

    public ControlQuality(List<Storage> list) {
        if (list == null) {
            throw new IllegalArgumentException("One of the arguments equal null");
        }
        storageList = list;
    }

    public List<Storage> getStorageList() {
        return storageList;
    }

    public void addFoodList(List<Food> foodList) {
        for(Food food : foodList) {
            addFood(food);
        }
    }

    public boolean addFood(Food food) {
        boolean rsl = false;
        for (Storage storage : storageList) {
            rsl = storage.accept(food);
            if (rsl) {
                storage.add(food);
                break;
            }
        }
        return rsl;
    }
}
