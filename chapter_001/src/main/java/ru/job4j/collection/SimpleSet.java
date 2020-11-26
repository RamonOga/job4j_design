package ru.job4j.collection;

import java.util.*;

public class SimpleSet<T> implements Iterable<T> {

    private SimpleArray<T> data;
    private int size;

    public SimpleSet() {
        this.data = new SimpleArray<>();
        this.size = 0;
    }

    public boolean add(T model) {
        if (!data.contains(model)) {
            data.add(model);
            this.size++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }
}
