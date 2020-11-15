package ru.job4j.it;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    private int calcAllElem() {
        int rsl = 0;
        for (int[] arr : data) {
            for (Integer i : arr) {
                rsl++;
            }
        }
        return rsl;
    }

    @Override
    public boolean hasNext() {
        return row + column < calcAllElem();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (column >= data[row].length) {
            row++;
            column = 0;
        }
        while (data[row].length == 0) {
            row++;
        }
        return data[row][column++];
    }

    public static void main(String[] args) {
        int[][] in = {
                {1}, {}, {}, {}, {2}
        };
        System.out.println(in[0].length);
        System.out.println(in[1].length);
    }
}