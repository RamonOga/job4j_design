package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

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

    @Test
    public void testDelete() {
        SimpleHashMap<String, Integer> simple = new SimpleHashMap();
        simple.insert("java", 2);
        simple.insert("js", 9);
        simple.insert("kotlin", 1);
        Assert.assertEquals(3, simple.size());
        Assert.assertTrue(simple.delete("js"));
        Assert.assertNull(simple.get("js"));
        Assert.assertTrue(simple.delete("java"));
        Assert.assertNull(simple.get("java"));
        Assert.assertTrue(simple.delete("kotlin"));
        Assert.assertNull(simple.get("kotlin"));
        Assert.assertEquals(0, simple.size());
    }

    @Test
    public void testIteratorWhenOneElement() {
        SimpleHashMap<String, Integer> simple = new SimpleHashMap();
        simple.insert("java", 2);
        Iterator<String> it = simple.iterator();
        String expected = "java";
        Assert.assertTrue(it.hasNext());
        Assert.assertEquals(expected, it.next());
        Assert.assertFalse(it.hasNext());
    }

    @Test
    public void testIteratorWhenFiveElements() {
        SimpleHashMap<String, Integer> simple = new SimpleHashMap();
        simple.insert("java", 2);
        simple.insert("js", 9);
        simple.insert("kotlin", 1);
        simple.insert("c++", 3);
        simple.insert("c#", 0);
        Iterator<String> it = simple.iterator();
        String expected0 = "c#";
        String expected1 = "kotlin";
        String expected2 = "java";
        String expected3 = "c++";
        String expected9 = "js";
        Assert.assertTrue(it.hasNext());
        Assert.assertEquals(expected0, it.next());
        Assert.assertTrue(it.hasNext());
        Assert.assertEquals(expected1, it.next());
        Assert.assertTrue(it.hasNext());
        Assert.assertEquals(expected2, it.next());
        Assert.assertTrue(it.hasNext());
        Assert.assertEquals(expected3, it.next());
        Assert.assertTrue(it.hasNext());
        Assert.assertEquals(expected9, it.next());
        Assert.assertFalse(it.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorWhenNoSuchElementException() {
        SimpleHashMap<String, Integer> simple = new SimpleHashMap();
        Iterator<String> it = simple.iterator();
        it.next();
    }

    @Test
    public void testIteratorWhenHasNextByEmptyMap() {
        SimpleHashMap<String, Integer> simple = new SimpleHashMap();
        Iterator<String> it = simple.iterator();
        Assert.assertFalse(it.hasNext());
    }

    @Test
    public void testSize() {
        SimpleHashMap<String, Integer> simple = new SimpleHashMap();
        Assert.assertEquals(0, simple.size());
        simple.insert("java", 2);
        Assert.assertEquals(1, simple.size());
        simple.insert("js", 9);
        Assert.assertEquals(2, simple.size());
        simple.insert("kotlin", 1);
        Assert.assertEquals(3, simple.size());
        simple.insert("c++", 3);
        Assert.assertEquals(4, simple.size());
        simple.insert("c#", 0);
        Assert.assertEquals(5, simple.size());
        simple.delete("java");
        Assert.assertEquals(4, simple.size());
        simple.delete("js");
        Assert.assertEquals(3, simple.size());
        simple.delete("kotlin");
        Assert.assertEquals(2, simple.size());
        simple.delete("c++");
        Assert.assertEquals(1, simple.size());
        simple.delete("c#");
        Assert.assertEquals(0, simple.size());
    }

    @Test
    public void testArraySizeup() {
        SimpleHashMap<String, Integer> simple = new SimpleHashMap();
        simple.insert("one", 22);
        simple.insert("two", 22);
        simple.insert("three", 22);
        simple.insert("four!", 22);
        simple.insert("five", 22);
        simple.insert("six666", 22);
        simple.insert("seven", 22);
        simple.insert("eight", 22);
        simple.insert("nine9", 22);
        simple.insert("ten", 22);
        simple.insert("eleven", 22);
        simple.insert("twelve", 22);
        simple.insert("thirteen", 22);
        simple.insert("fourteen", 22);
        simple.insert("fifteen1515", 22);
        simple.insert("sixteen", 22);
        simple.insert("seventeen", 22);
        simple.insert("eighteen", 22);
        simple.insert("nineteen19", 22);
        simple.insert("twenty", 22);
        Assert.assertEquals(20, simple.size());
        Assert.assertEquals(64, simple.tableSize());
    }



}