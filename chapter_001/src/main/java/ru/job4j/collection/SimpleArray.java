package ru.job4j.collection;

import javax.swing.*;
import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

  private Object[] data;
  private int realSize;
  private int size;
  private int modCount;

  public SimpleArray() {
    this.data = new Object[10];
    this.realSize = 10;
    this.size = 0;
    this.modCount = 0;
  }

  public T get(int index) {
    return (T) data[Objects.checkIndex(index, size)];
  }

  public void add(T model) {
    if (!(realSize < size)) {
      getArrayMore();
    }
    data[size] = model;
    size++;
    modCount++;
  }

  private void getArrayMore() {
    data = Arrays.copyOf(data, realSize * 2);
    realSize *= 2;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {

      int iterModCount = modCount;
      int iterCount = 0;
      @Override
      public boolean hasNext() {
        return iterCount < size;
      }

      @Override
      public T next() {
        if (iterCount >= size) {
          throw new NoSuchElementException();
        }
        if (iterModCount != modCount) {
          throw new ConcurrentModificationException();
        }
        return (T) data[iterCount++];
      }
    };
  }
}