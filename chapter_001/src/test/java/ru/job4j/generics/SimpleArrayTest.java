package ru.job4j.generics;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import java.util.Iterator;

public class SimpleArrayTest extends TestCase {

    @Test
    public void testAdd() {
        SimpleArray simple = new SimpleArray(1);
        simple.add("test");
        int expect = 1;
        Assert.assertEquals(expect, simple.size());
    }

    @Test
    public void testGet() {
        SimpleArray simple = new SimpleArray(1);
        simple.add('a');
        char expect = 'a';
        Assert.assertEquals(expect, simple.get(0));
    }

    @Test
    public void testSize() {
        SimpleArray sizeTest = new SimpleArray(10);
        int expect = 10;
        Assert.assertEquals(expect, sizeTest.size());
    }

    @Test
    public void testRemove() {
        SimpleArray simple = new SimpleArray(3);
        simple.add(1);
        simple.add(2);
        simple.add(3);
        simple.remove(1);
        int expect0 = 1;
        int expect1 = 3;
        Assert.assertEquals(expect0, simple.get(0));
        Assert.assertEquals(expect1, simple.get(1));
    }

    @Test
    public void testSet() {
        SimpleArray simple = new SimpleArray(4);
        simple.add(1);
        simple.add(2);
        simple.add(3);
        simple.set(0, 99);
        int expect = 99;
        Assert.assertEquals(expect, simple.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetEmpty() {
        SimpleArray simple = new SimpleArray(0);
        simple.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetEmpty() {
        SimpleArray simple = new SimpleArray(1);
        simple.add("java");
        simple.set(22, "JS");
    }

    @Test
    public void testIteratorThenEmpty() {
        SimpleArray simple = new SimpleArray(0);
        Iterator<String> it = simple.iterator();
        Assert.assertFalse(it.hasNext());
    }

    @Test
    public void testIterator() {
        SimpleArray simple = new SimpleArray(2);
        simple.add(1);
        simple.add(22);
        Iterator<Integer> it = simple.iterator();
        Assert.assertTrue(it.hasNext());
        it.next();
        Assert.assertTrue(it.hasNext());
        it.next();
        Assert.assertFalse(it.hasNext());
    }
}