package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private int size = 0;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> tail = head;
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
        Node<T> node;
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
        Node<T> one;
        Node<T> two;
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
        Node<T> one = null;
        Node<T> two = head;
        Node<T> three = head.next;
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
            Node<T> node = head;

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

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}