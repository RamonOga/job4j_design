package ru.job4j.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinkedForMap<K, T> implements Iterable<T> {

    private NodeMap<K, T> head;
    private int size = 0;

    public NodeMap<K, T> getHead() {
        return head;
    }

    public void add(K key, T value, int hash) {
        NodeMap<K, T> node = new NodeMap<K, T>(key, value, null, hash);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        NodeMap<K, T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        NodeMap<K, T> node;
        if (head.next == null) {
            node = head;
            head = null;
            size--;
            return node.value;
        }
        node = head;
        head = head.next;
        size--;
        return node.value;
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        NodeMap<K, T> one;
        NodeMap<K, T> two;
        if (head.next == null) {
            two = head;
            head = null;
            size--;
            return two.value;
        }
        one = head;
        two = one;
        while (one.next != null) {
            two = one;
            one = one.next;
        }
        two.next = null;
        size--;
        return one.value;
    }

    public void revert() {
        if (head == null) {
            return;
        }
        NodeMap<K, T> one = null;
        NodeMap<K, T> two = head;
        NodeMap<K, T> three = head.next;
        while (three != null) {
            two.next = one;
            one = two;
            two = three;
            three = two.next;
            two.next = one;
        }
        head = two;
    }

    public void print() {
        Iterator<T> it = this.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + ", ");
        }
        System.out.println();
    }

    public boolean checkHead() {
        return head == null;
    }

    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            NodeMap<K, T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }
}