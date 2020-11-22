package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayTest {

  @Test
  public void whenAddThenGet() {
    SimpleArray<String> array = new SimpleArray<>();
    array.add("first");
    String rsl = array.get(0);
    assertThat(rsl, is("first"));
  }

  @Test
  public void whenAddThenIt() {
    SimpleArray<String> array = new SimpleArray<>();
    array.add("first");
    String rsl = array.iterator().next();
    assertThat(rsl, is("first"));
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void whenGetEmpty() {
    SimpleArray<String> array = new SimpleArray<>();
    array.get(0);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void whenGetOutBound() {
    SimpleArray<String> array = new SimpleArray<>();
    array.add("first");
    array.get(1);
  }

  @Test(expected = NoSuchElementException.class)
  public void whenGetEmptyFromIt() {
    SimpleArray<String> array = new SimpleArray<>();
    array.iterator().next();
  }

  @Test(expected = ConcurrentModificationException.class)
  public void whenCorruptedIt() {
    SimpleArray<String> array = new SimpleArray<>();
    array.add("first");
    Iterator<String> it = array.iterator();
    array.add("second");
    it.next();
  }
}