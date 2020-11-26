package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


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
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenDelete() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        assertThat(1, is(linked.deleteFirst()));
    }

    @Test
    public void whenAddThenIter() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
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
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenHasNextFalse() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        Iterator<Integer> it = linked.iterator();
        System.out.println(linked.size());
        Assert.assertTrue(it.hasNext());
        it.next();
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
}