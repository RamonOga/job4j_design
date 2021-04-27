package ru.job4j.solid.srp.exampleone;

public interface IUserStorage {

    void add(User user);

    User get(int index);

    void delete(User user);

    void loadDB();

}
