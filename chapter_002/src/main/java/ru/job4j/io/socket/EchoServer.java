package ru.job4j.io.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerAnswer answer = new ServerAnswer();
        boolean run = true;
        StringBuffer strBuffer = new StringBuffer();
        try (ServerSocket server = new ServerSocket(9000)) {
            while (run) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        strBuffer.append(str);
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r".getBytes());
                    out.write("Hello, dear friend.\r\n".getBytes());
                    out.write(answer.answer(strBuffer.toString()).getBytes());
                    run = answer.checkExit(strBuffer.toString());
                }
            }
        }
    }
}