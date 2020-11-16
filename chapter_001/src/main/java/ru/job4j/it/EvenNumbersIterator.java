package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int count;

    public EvenNumbersIterator(int[] input) {
        this.data = input;
    }

    private boolean checkEven(int input) {
        return data[input] % 2 == 0;
    }

    @Override
    public boolean hasNext() {
        if (count >= data.length) {
            throw new NoSuchElementException();
        }
        return checkEven(count + 1);
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            throw new NoSuchElementException();
        }
        while (!checkEven(count)) {
            count++;
        }
        return data[count++];
    }

    public static void main(String[] args) {
    }
}
