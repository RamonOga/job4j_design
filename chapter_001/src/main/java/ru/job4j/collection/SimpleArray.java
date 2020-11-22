package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

  private Object[] data;
  private int size;
  private int modCount;

  public SimpleArray() {
    data = new Object[0];
    size = 0;
    modCount = 0;
  }

  public T get(int index) {
    return (T) data[Objects.checkIndex(index, size)];
  }

  public void add(T model) {
    data = getArrayMore();
    data[size] = model;
    size++;
    modCount++;
  }

  private T[] getArrayMore() {
    Object[] newArray = new Object[size + 1];
    for (int i = 0; i < size; i++) {
      newArray[i] = data[i];
    }
    return (T[]) newArray;
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