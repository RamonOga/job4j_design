package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class SimpleSetTest {

    @Test
    public void whenAddTest() {
        SimpleSet<Integer> s = new SimpleSet<>();
        s.add(1);
        s.add(2);
        Integer expected1 = 1;
        Integer expected2 = 2;
        Iterator<Integer> it = s.iterator();
        Assert.assertEquals(expected1, it.next());
        Assert.assertEquals(expected2, it.next());
    }

    @Test
    public void whenAddRepetition() {
        SimpleSet<Integer> s = new SimpleSet<>();
        s.add(1);
        s.add(1);
        s.add(1);
        Integer expected1 = 1;
        Iterator<Integer> it = s.iterator();
        Assert.assertEquals(expected1, it.next());
        Assert.assertFalse(it.hasNext());
    }

    @Test
    public void whenAddNulls() {
        SimpleSet<Integer> s = new SimpleSet<>();
        s.add(1);
        s.add(null);
        s.add(null);
        Integer expected = 1;
        Iterator<Integer> it = s.iterator();
        Assert.assertEquals(expected, it.next());
    }

}