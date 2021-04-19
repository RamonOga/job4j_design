package ru.job4j.solid.ocp.exampleTwo;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    private final int id;
    private final String owner;
    private final List<UserData> userDataList;

    public UserStorage(int id, String owner) {
        this.id = id;
        this.owner = owner;
        this.userDataList = new ArrayList<>();
    }

    public List<UserData> getUserDataList() {
        return userDataList;
    }

    public void add(UserData userData) {
        userDataList.add(userData);
    }

    public void saveByAWSCloud() {
        // load by cloud code
        System.out.println("%s, your data save to AWS cloud".formatted(owner));
    }
}
