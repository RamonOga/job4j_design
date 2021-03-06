package ru.job4j.collection;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<>();

    public T pop() {
        return linked.deleteLast();
    }

    public void push(T value) {
        linked.add(value);
    }

    public boolean checkHead() {
       return linked.checkHead();
    }

    public boolean isEmpty() {
        return !linked.iterator().hasNext();
    }
}