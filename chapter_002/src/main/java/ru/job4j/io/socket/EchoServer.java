package ru.job4j.io.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.io.logs.UsageLog4j;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        ServerAnswer answer = new ServerAnswer();
        StringBuffer buffer = new StringBuffer();
        boolean run = true;
        try (ServerSocket server = new ServerSocket(1023)) {
            while (run) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        System.out.println(str);
                        buffer.append(str);
                        str = in.readLine();
                    }
                    answer.answer(buffer.toString());
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write("Hello, dear friend.\r\n".getBytes());
                    out.write((answer.getAnswer() + "\n").getBytes());
                    run = answer.getCheckExit();
                    buffer.delete(0, buffer.length());
                } catch (Exception e) {
                    LOG.error("Something went wrong", e);
                }
            }
        } catch (Exception e) {
            LOG.error("Something went wrong", e);
        }

    }
}