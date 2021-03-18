package ru.job4j.gc;


public class Runner {

    public static void main(String[] args) {
        GCDemo gcDemo = new GCDemo();

        gcDemo.info();
        for (int i = 0 ; i < 32500; i++) {
            new User();
        }
        gcDemo.info();
    }
}
