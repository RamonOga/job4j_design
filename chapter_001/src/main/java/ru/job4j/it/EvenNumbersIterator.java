package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int position;

    public EvenNumbersIterator(int[] input) {
        this.data = input;
        position = 0;
    }

    private boolean checkPosition() {
        return position < data.length;
    }

    @Override
    public boolean hasNext() {
        if (checkPosition()) {
            while ((data[position] % 2 != 0)) {
                position++;
                if (!checkPosition()) {
                    break;
                }
            }
        }
        return checkPosition();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[position++];
    }

    public static void main(String[] args) {
        Iterator<Integer> it = new EvenNumbersIterator(new int[] {1, 2, 3, 4, 5, 6, 7});

        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
    }
}
