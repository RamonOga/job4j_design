package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> node = head;
        head = head.next;
        return node.value;
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> node = head;
        Node<T> rsl;
        if (head.next != null) {
            rsl = head;
            head = null;
            return rsl.value;
        }
        while (node.next.next != null) {
            node = node.next;
        }
        rsl = node.next;
        node.next = null;
        return rsl.value;
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

    public static void main(String[] args) {
        ForwardLinked fo = new ForwardLinked();

        fo.add("J");
        for (Iterator<String> it =  fo.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
        System.out.println("=====>>>" + fo.deleteLast());
    }

}