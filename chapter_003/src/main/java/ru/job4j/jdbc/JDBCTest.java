package ru.job4j.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Map<String, String> properties = parsProp("app.properties");
        startConnection(properties.get("url"), properties.get("login"), properties.get("password"));
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

    public static Map<String, String> parsProp(String fileProperties) {
        Map<String, String> rsl = new HashMap<>();
        try (BufferedReader dr = new BufferedReader(new FileReader(fileProperties))) {
            dr.lines().map(a -> a.split("=")).forEach(a -> rsl.put(a[0], a[1]));
        } catch (IOException e) {
            e.fillInStackTrace();
            System.out.println(e.getMessage());
        }
        return rsl;
    }
}