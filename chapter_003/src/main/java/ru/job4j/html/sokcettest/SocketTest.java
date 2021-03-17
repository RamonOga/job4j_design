package ru.job4j.html.sokcettest;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SocketTest {
    private Connection connection;

    public SocketTest() {
        connection = getConnection();
    }

    public void startSocket(List<Post> list) {
        try (ServerSocket ss = new ServerSocket(8081)) {
            while (!ss.isClosed()) {
                Socket socket = ss.accept();
                try(OutputStream bos = socket.getOutputStream()) {
                    bos.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    list.forEach(a -> {
                        try {
                            bos.write(a.toString().getBytes());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

                }
            }
        } catch(Exception e) {
            e.fillInStackTrace();
        }
    }

    public List<Post> getPostList() {
        List<Post> rsl = new ArrayList<>();
        String query = "select * from posts;";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                rsl.add(new Post(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("href"),
                        rs.getString("descr"),
                        rs.getObject(5, LocalDateTime.class)));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return rsl;
    }

    private Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/post_db",
                    "postgres",
                    "password");

        } catch (Exception sqle) {
            sqle.fillInStackTrace();
        }
        return conn;
    }
    public static void main(String[] args) {
        SocketTest st = new SocketTest();
        st.startSocket(st.getPostList());
    }
}

