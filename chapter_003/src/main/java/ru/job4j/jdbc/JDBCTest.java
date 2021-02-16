package ru.job4j.jdbc;

import javax.swing.text.html.Option;
import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.Optional;
import java.util.stream.Collectors;

public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException {

        startConnection(parsProp("url"), parsProp("login"), parsProp("password"));

    }

    public static void startConnection(String url, String login, String pass) throws ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        try (Connection conn = DriverManager.getConnection(url, login, pass)) {
            DatabaseMetaData md = conn.getMetaData();
            System.out.println(md.getUserName());
            System.out.println(md.getURL());
            System.out.println(md.getDatabaseProductName());
            System.out.println(md.getDatabaseProductVersion());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static String parsProp(String input) {
        Optional<String> rsl = Optional.empty();
        try (BufferedReader dr = new BufferedReader(new FileReader("app.properties"))) {
            rsl = dr.lines()
                    .filter(a -> a.contains(input))
                    .findFirst();
        } catch (IOException e) {
            e.fillInStackTrace();
            System.out.println(e.getMessage());
        }
        if (rsl.isPresent()) {
            return rsl.get().split("=")[1];
        } else {
            throw new IllegalArgumentException("wrong parameter for pars: " + input);
        }
    }
}
