package ru.job4j.solid.ocp.exampleTwo;

public class UserData {
    private int id;
    private String owner;
    private String data;

    public UserData(int id, String owner, String data) {
        this.id = id;
        this.owner = owner;
        this.data = data;
    }
}
