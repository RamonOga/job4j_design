package ru.job4j.hashandequals;

public class Node<T> {
    T value;
    Node<T> left;
    Node<T> right;

    public Node(T v, Node<T> l, Node<T> r) {
        value = v;
        left = l;
        right = r;
    }
}