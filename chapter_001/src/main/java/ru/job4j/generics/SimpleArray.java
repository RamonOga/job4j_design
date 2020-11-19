package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] data;
    private int size;
    private int position = 0;

    public SimpleArray() {
        data = new Object[size];
        size = 0;
    }

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
        return input >= 0 && input < size;
    }

    public int size() {
        return size;
    }

    public void add(T input) {
        data = giveArrayMore();
        data[size - 1] = input;
    }

    public Object get(int input) {
        if (!inRange(input)) {
            return null;
        }
        return data[input];
    }

    public boolean set(int index, T value) {
        if (!inRange(index)) {
            return false;
        }
        data[index] = value;
        return true;
    }

    public boolean remove(int input) {
        Object[] newArray = new Object[size - 1];
        if (!inRange(input)) {
            return false;
        }
        data[input] = null;
        System.arraycopy(data, input + 1, data, input, size - input - 1);
        data = giveArrayLess();
        return true;
    }

    private Object[] giveArrayMore() {
        Object[] newArray = new Object[size + 1];
        for (int i = 0; i < size; i++) {
            newArray[i] = data[i];
        }
        size++;
        return newArray;
    }

    private Object[] giveArrayLess() {
        Object[] newArray = new Object[size - 1];
        for (int i = 0; i < size - 1; i++) {
            newArray[i] = data[i];
        }
        size--;
        return newArray;
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
