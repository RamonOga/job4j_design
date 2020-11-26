package ru.job4j.collection;

import java.util.*;
import java.util.LinkedList;

public class SimpleSet<T> implements Iterable<T> {

    private SimpleArray<T> data;
    private int modCount;
    private int size;

    public SimpleSet() {
        this.data = new SimpleArray<>();
        this.modCount = 0;
        this.size = 0;
    }

    public boolean add(T model) {
        if (!data.contains(model)) {
            data.add(model);
            this.size++;
            this.modCount++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int iterCount = 0;
            private int iterModCount = modCount;

            @Override
            public boolean hasNext() {
                return iterCount < size;
            }

            @Override
            public T next() {
                if (iterModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                   return data.get(iterCount++);
            }
        };
    }
}
