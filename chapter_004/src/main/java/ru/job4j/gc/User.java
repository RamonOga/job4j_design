package ru.job4j.gc;

public class User {
    private String name;
    private int id;

    public User(String name, int age) {
        this.id = age;
        this.name = name;
    }
    public User() {
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("User # " + this.id + " deleted");
    }
}
