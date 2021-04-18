package ru.job4j.solid.srp.exampleOne;

import java.util.UUID;

public class User {
    UUID uuid;
    int age;
    String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
        this.uuid = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid=" + uuid +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
