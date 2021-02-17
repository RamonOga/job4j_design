package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Runner {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("app.properties");
        Properties properties = new Properties();
        properties.load(fis);
        TableEditor te = new TableEditor(properties);
        te.dropTable("demo_table");
        te.createTable("demo_table");
        te.addColumn("demo_table", "new_column", "text");
        te.addColumn("demo_table", "for_rename", "text");
        System.out.println(te.getScheme("demo_table"));
        te.dropColumn("demo_table", "new_column");
        System.out.println(te.getScheme("demo_table"));
        te.renameColumn("demo_table", "for_rename", "renamed");
        System.out.println(te.getScheme("demo_table"));
        te.close();
    }
}
