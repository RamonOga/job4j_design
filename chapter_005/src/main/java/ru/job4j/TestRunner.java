package ru.job4j;

public class TestRunner implements Cloneable {
    String name;
    int age;

    public TestRunner(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
