package ru.job4j.collection;

public class Node<E> {
    E item;
    Node<E> next;
    Node<E> pred;

    public Node(Node<E> pred, E element, Node<E> next) {
        this.pred = pred;
        this.item = element;
        this.next = next;
    }
}
