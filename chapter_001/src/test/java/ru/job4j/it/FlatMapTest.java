package ru.job4j.it;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FlatMapTest {
    @Test
    public void whenDiffNext() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1).iterator(),
                List.of(2, 3).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        assertThat(flat.next(), is(1));
        assertThat(flat.next(), is(2));
        assertThat(flat.next(), is(3));
    }

    @Test
    public void whenSeqNext() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        assertThat(flat.next(), is(1));
        assertThat(flat.next(), is(2));
        assertThat(flat.next(), is(3));
    }

    @Test
    public void whenMultiHasNext() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        assertThat(flat.hasNext(), is(true));
        assertThat(flat.hasNext(), is(true));
    }

    @Test
    public void whenHasNextFalse() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        assertThat(flat.next(), is(1));
        assertThat(flat.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmpty() {
        Iterator<Iterator<Object>> data = List.of(
                List.of().iterator()
        ).iterator();
        FlatMap<Object> flat = new FlatMap<>(data);
        flat.next();
    }

    @Test
    public void whenThreeEmpty() {
        Iterator<Iterator<Object>> data = List.of(
                List.of().iterator(),
                List.of().iterator(),
                List.of().iterator()
        ).iterator();
        FlatMap<Object> flat = new FlatMap<>(data);
        assertThat(flat.hasNext(), is(false));
    }

    @Test
    public void whenTwoEmptyAndOneNoEmtpy() {
        Iterator<Integer> it1 = Collections.emptyIterator();
        Iterator<Integer> it2 = Collections.emptyIterator();
        Iterator<Integer> it3 = List.of(1).iterator();
        Iterator<Iterator<Integer>> data = List.of(it1, it2, it3).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        assertThat(flat.hasNext(), is(true));
    }
}