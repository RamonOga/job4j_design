package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.assertEquals;

public class ForwardLinkedTest {

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteFirst() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.deleteFirst();
        linked.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteEmptyLinked() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.deleteFirst();
    }

    @Test
    public void whenMultiDelete() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.deleteFirst();
        Iterator<Integer> it = linked.iterator();
        int rsl = it.next();
        assertEquals(2, rsl);
    }

    @Test
    public void whenDelete() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        int rsl = linked.deleteFirst();
        assertEquals(1, rsl);
    }

    @Test
    public void whenAddThenIter() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        Iterator<Integer> it = linked.iterator();
        int rsl = it.next();
        assertEquals(1, rsl);
        rsl = it.next();
        assertEquals(2, rsl);
    }

    @Test
    public void whenAddAndRevertThenIter() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        int rsl = it.next();
        assertEquals(4, rsl);
        rsl = it.next();
        assertEquals(3, rsl);
        rsl = it.next();
        assertEquals(2, rsl);
        rsl = it.next();
        assertEquals(1, rsl);
    }

    @Test
    public void whenHasNextFalse() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        Iterator<Integer> it = linked.iterator();
        Assert.assertFalse(it.hasNext());
    }

    @Test
    public void sizeMethodTest() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        Assert.assertEquals(0, linked.size());
        linked.add(1);
        Assert.assertEquals(1, linked.size());
        linked.deleteFirst();
        Assert.assertEquals(0, linked.size());
        linked.add(2);
        Assert.assertEquals(1, linked.size());
        linked.deleteLast();
        Assert.assertEquals(0, linked.size());
        linked.add(3);
        linked.add(4);
        linked.add(5);
        Assert.assertEquals(3, linked.size());
        linked.deleteLast();
        Assert.assertEquals(2, linked.size());
        linked.deleteFirst();
        Assert.assertEquals(1, linked.size());
        linked.deleteLast();
        Assert.assertEquals(0, linked.size());
    }

   /* @Test(expected = NoSuchElementException.class)
    public void whenRevertNull() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.revert();
    }*/

    @Test
    public void whenAddAndRevertOneElement() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        int rsl = it.next();
        assertEquals(1, rsl);
    }
}