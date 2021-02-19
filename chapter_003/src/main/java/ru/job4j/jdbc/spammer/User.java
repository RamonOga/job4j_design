package ru.job4j.jdbc.spammer;

public class User {
    String name;
    String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "EmailUser{"
                + "name='" + name + '\''
                + ", email='" + email + '\''
                + '}';
    }
}
