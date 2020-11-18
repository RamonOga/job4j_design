package ru.job4j.it;


import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertThat;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    private boolean isEmpty() {
        for (int[] arr : data) {
            if (arr.length != 0) {
                return false;
            }
        }
        return true;
    }   

    @Override
    public boolean hasNext() {
        return !(row == data.length - 1
                && column == data[data.length - 1].length)
                && !isEmpty();
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
                {}
        };
        MatrixIt it = new MatrixIt(in);
        System.out.println(it.hasNext());

    }
}