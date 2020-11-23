package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListTest {

    @Test
    public void addIntegerTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        Integer expected = 1;
        Assert.assertEquals(expected, linkedList.get(0));
    }

    @Test
    public void addStringTest() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("java");
        String expected = "java";
        Assert.assertEquals(expected, linkedList.get(0));
    }

    @Test
    public void sizeTest() {
        LinkedList<Character> linkedList = new LinkedList<>();
        linkedList.add('j');
        linkedList.add('a');
        linkedList.add('v');
        linkedList.add('a');
        int expected = 4;
        Assert.assertEquals(expected, linkedList.size());
    }

    @Test
    public void hasNextAndNextTest() {
        LinkedList<Character> linkedList = new LinkedList<>();
        linkedList.add('J');
        Iterator<Character> it = linkedList.iterator();
        Assert.assertTrue(it.hasNext());
        Assert.assertEquals((Character)'J', it.next());
        Assert.assertFalse(it.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void NoSuchElementException() {
        LinkedList<Boolean> linkedList = new LinkedList<>();
        linkedList.add(true);
        linkedList.add(false);
        Iterator<Boolean> it = linkedList.iterator();
        it.next();
        it.next();
        it.next();

    }

    @Test(expected = ConcurrentModificationException.class)
    public void ConcurrentModificationException() {
        LinkedList<Boolean> linkedList = new LinkedList<>();
        linkedList.add(true);
        linkedList.add(false);
        Iterator<Boolean> it = linkedList.iterator();
        linkedList.add(false);
        linkedList.add(false);
        it.next();

    }

}