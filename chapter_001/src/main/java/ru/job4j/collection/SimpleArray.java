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
    if (!(size < realSize)) {
      getArrayMore();
    }
    data[size] = model;
    size++;
    modCount++;
  }

  public boolean contains(T model) {
    return indexOf(model) >= 0;
  }

  public int indexOf(T model) {
    Object[] arr = data;
    for (int i = 0; i < size; i++) {
      if (Objects.equals(arr[i], model)) {
        return i;
      }
    }

    return -1;
  }

  public int size() {
    return this.size;
  }

  private void getArrayMore() {
    data = Arrays.copyOf(data, realSize * 2);
    this.realSize *= 2;
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