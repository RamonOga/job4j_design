package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleHashMapTest {

    @Test
    public void addTest() {
        SimpleHashMap<Integer, String> simple = new SimpleHashMap();
        simple.insert(1, "java");
        simple.insert(2, "js");
        simple.insert(1, "kotlin");
        Assert.assertEquals(2, simple.size());

    }

    @Test
    public void getTest() {
        SimpleHashMap<String, Integer> simple = new SimpleHashMap();
        simple.insert("java", 999);
        simple.insert("js", 111);
        Integer expected1 = 999;
        Integer expected2 = 111;
        Assert.assertEquals(expected2, simple.get("js"));
        Assert.assertEquals(expected1, simple.get("java"));
    }

}