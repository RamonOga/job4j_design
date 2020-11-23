package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements Iterable<E> {
    private int size;
    private int modCount;
    private Node<E> first;
    private Node<E> last;

    public LinkedList() {
        size = 0;
        modCount = 0;
        first = null;
        last = null;
    }

    public int size() {
        return size;
    }

    public void add(E model) {
        Node<E> tmp = last;
        Node<E> newNode =  new Node<>(tmp, model, null);
        last = newNode;
       if (tmp == null) {
           first = last;
       } else {
           tmp.next = newNode;
       }
        size++;
        modCount++;
    }

    public E get(int index) {
        Node<E> rsl = first;

        for (int i = 0; i < index; i++) {
            rsl = rsl.next;
        }
        return (E) rsl.item;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            int iterCount = 0;
            final int iterModCount = modCount;
            Node<E> tmp = first;

            @Override
            public boolean hasNext() {
               return iterCount < size;
            }

            @Override
            public E next() {
                if (iterCount >= size) {
                    throw new NoSuchElementException();
                }
                if (iterModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                E rsl = tmp.item;
                tmp = tmp.next;
                iterCount++;
                return rsl;
            }
        };
    }
}
