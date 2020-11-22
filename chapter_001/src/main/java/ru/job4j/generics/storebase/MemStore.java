package ru.job4j.generics.storebase;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        if (model != null) {
            mem.add(model);
        }
    }

    @Override
    public boolean replace(String id, T model) {
        final int index = indexOf(id);
        if (index != -1) {
            mem.set(index, model);
            return true;
        }
       return false;
    }

    @Override
    public boolean delete(String id) {
        final int index = indexOf(id);
        if (index != -1) {
            mem.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        return mem.stream()
                .filter(a -> a.getId()
                        .equals(id))
                .findFirst()
                .orElse(null);

    }

    private int indexOf(String id) {
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}