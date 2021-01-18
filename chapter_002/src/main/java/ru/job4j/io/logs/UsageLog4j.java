package ru.job4j.io.logs;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {

        byte byt = 127;
        char ch = 'c';
        short sho = 1;
        int in = 2;
        float flo = 5.0f;
        long lo = 3;
        double doub = 4.0;
        boolean bool = true;

        LOG.debug("Primitive data types byte(8 bits) : {}, char(16bits) : {}, short(16bits) : {}, int(16bits) : {}", byt, ch, sho, in);
        LOG.debug("Primitive data types float(16bits) : {}, long(32bits) : {}, double(32bits) : {}, boolean(1-32bits) {}", flo, lo, doub, bool);
    }
}
