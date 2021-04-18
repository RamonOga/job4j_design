package ru.job4j.solid.srp.exampleOne;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserStorage implements IUserStorage {

    List<User> list;

    public UserStorage() {
        this.list = new ArrayList<>();
    }

    @Override
    public void loadDB() {
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/test", "login", "pass");
            PreparedStatement pStatement = connection.prepareStatement("select * from userttable");
                ) {
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                //...
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    @Override
    public void add(User user) {
        if(user == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        list.add(user);

    }

    @Override
    public void delete(User user) {
        if(user == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        list.remove(user);
    }

    @Override
    public User get(int index) {
        return list.get(index);
    }
}
