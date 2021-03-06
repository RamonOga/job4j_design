package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] data;
    private int size;
    private int count = 0;

    public SimpleArray(T[] input) {
        data = input;
        size = input.length;
    }

    public SimpleArray(int input) {
        data = new Object[input];
        size = input;
    }

    public int indexOf(T input) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(input)) {
                return i;
            }
        }
        return -1;
    }

    private boolean inRange(int input) {
        return input >= 0 && input < count;
    }

    public int size() {
        return count;
    }

    public void add(T input) {
        if (count >= size) {
            throw new IndexOutOfBoundsException();
        }
        data[count++] = input;
    }

    public T get(int input) {
        if (!inRange(input)) {
            throw new IndexOutOfBoundsException();
        }
        return (T) data[input];
    }

    public boolean set(int index, T value) {
        if (!inRange(index)) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = value;
        return true;
    }

    public boolean remove(int input) {
        if (!inRange(input)) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(data, input + 1, data, input, size - input - 1);
        data[size - 1] = null;
        count--;
        return true;
    }

    public void print() {
        System.out.print(" [");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println("] ");
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return inRange(position);
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) data[position++];
            }
        };
    }
}
