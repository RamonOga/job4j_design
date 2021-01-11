package ru.job4j.fortest;

public class Runner {

    public int fibo(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int one = 0;
        int two = 1;
        int rsl = 0;
        for (int i = 1; i < n; i++) {
            rsl = one + two;
            one = two;
            two = rsl;
        }

        return rsl;
    }

    public static void main(String[] args) {
        Runner r = new Runner();
        System.out.println(r.fibo(4));
    }
}
