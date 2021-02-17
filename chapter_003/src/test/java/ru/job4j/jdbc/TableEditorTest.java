package ru.job4j.jdbc;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.Assert.*;

public class TableEditorTest {
    //TableEditor tb;

 /*   @Before
    public void getConnection() {
        try(FileInputStream fis = new FileInputStream("app.properties")) {
            Properties prop = new Properties();
            prop.load(fis);
            tb = new TableEditor(prop);
        } catch (IOException ie) {
            ie.fillInStackTrace();
        }
    }*/

    @Test()
    public void whenCreateTable() {
        try(FileInputStream fis = new FileInputStream("test_app.properties")) {
            Properties prop = new Properties();
            prop.load(fis);
            TableEditor tb = new TableEditor(prop);
            tb.createTable("test_table");
        } catch (IOException ie) {
            ie.fillInStackTrace();
        }
    }
}