package ru.job4j.forexam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannalNIO {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("123.zip");
        FileOutputStream fos = new FileOutputStream("321.zip");

        FileChannel channelIn = fis.getChannel();
        FileChannel channelOut = fos.getChannel();
        ByteBuffer bufferIn = ByteBuffer.allocate(1024);
        ByteBuffer bufferOut = ByteBuffer.allocate(1024);

        int r = channelIn.read(bufferIn);
        while (r != -1) {
            bufferIn.flip();
            while (bufferIn.hasRemaining()) {
                byte get = bufferIn.get();
                bufferOut.put(get);
            }
            bufferOut.flip();
            channelOut.write(bufferOut);
            bufferIn.clear();
            bufferOut.clear();
            r = channelIn.read(bufferIn);
            //System.out.println(r);
        }
    }
}
