package ru.job4j.leetcode;

public class MatrixDiagonalSum {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(diagonalSum2(mat));

    }

    public static int diagonalSum1(int[][] mat) {
        int rsl = 0;
        for (int row = 0; row < mat.length; row++) {
            for (int column = 0; column < mat.length; column++) {
                if ((row - column == 0) || ((row + column == mat.length - 1))) {
                    rsl += mat[row][column];
                }
            }
        }

        return rsl;
    }

    public static int diagonalSum2(int[][] mat) {
        int rsl = 0;
        int one = 0;
        int two = mat.length - 1;
        for (int i = 0; i < mat.length; i++) {
            if (one != two) {
                rsl = rsl + (mat[i][one] + mat[i][two]);
            } else {
                rsl = rsl + (mat[i][one]);
            }
                System.out.println();
                one += 1;
                two -= 1;

        }
        return rsl;
    }
}