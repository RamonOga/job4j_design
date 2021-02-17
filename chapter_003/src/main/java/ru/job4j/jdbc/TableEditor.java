package ru.job4j.jdbc;

import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(properties.getProperty("url1")
                , properties.getProperty("login")
                , properties.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) {
        try(Statement stat = connection.createStatement()) {
            String query = String.format(
                    "create table %s (%s, %s);"
                    , tableName, "id serial primary key"
                    , "name varchar(255)"
            );
            stat.execute(query);
        } catch (SQLException sq) {
            sq.printStackTrace();
        }
    }

    public void dropTable(String tableName) {
        try(Statement stat = connection.createStatement()) {
            String query = String.format("drop table %s;", tableName);
            stat.execute(query);
        } catch (SQLException sq) {
            sq.printStackTrace();
        }
    }

    public void addColumn(String tableName, String columnName, String type) {
        try(Statement stat = connection.createStatement()) {
            String query = String.format("alter table %s add column %s %s;", tableName, columnName, type);
            stat.execute(query);
        } catch (SQLException se) {
                se.printStackTrace();
        }
    }

    public void dropColumn(String tableName, String columnName) {
        try(Statement stat = connection.createStatement()) {
            String query = String.format("alter table %s drop column %s;", tableName, columnName);
            stat.execute(query);
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        try(Statement stat = connection.createStatement()) {
            String query = String.format("alter table %s rename column %s to %s;", tableName, columnName, newColumnName);
            stat.execute(query);
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}