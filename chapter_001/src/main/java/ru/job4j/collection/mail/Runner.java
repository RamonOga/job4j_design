package ru.job4j.collection.mail;

import java.util.HashMap;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {
    Map<String, String> m = new HashMap<>();
        System.out.println(m.put("qwe", "123"));
        System.out.println(m.put("qwe", "321"));
        System.out.println(m.get("222"));
    }

}
