package ru.job4j.collection;

import java.util.LinkedList;

import java.util.*;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean isBinary() {
        Predicate<Node<E>> pred = new Predicate<Node<E>>() {
            @Override
            public boolean test(Node<E> node) {
                return !node.children.isEmpty()
                        && node.children.size() > 2;
            }
        };
        Optional<Node<E>> rsl = findMethod(pred);
        return rsl.isEmpty();
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl;
        Predicate<Node<E>> pred = new Predicate<Node<E>>() {
            @Override
            public boolean test(Node<E> node) {
                return node.value.equals(value);
            }
        };
       rsl = findMethod(pred);
       return rsl;
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> rsl;
        Predicate<Node<E>> pred = new Predicate<Node<E>>() {
            @Override
            public boolean test(Node<E> node) {
                return node.value.equals(parent)
                        && !node.children.contains(child);
            }
        };
       rsl = findMethod(pred);
       if (rsl.isPresent()) {
           rsl.get().children.add(new Node<E>(child));
           return true;
       }
       return false;
    }

    private Optional<Node<E>> findMethod(Predicate<Node<E>> pred) {
        Optional<Node<E>> rsl = Optional.empty();
        List<Node<E>> list = new LinkedList<>();
        list.add(root);
        Node<E> node;
        while (!list.isEmpty()) {
            node = list.remove(0);
            if (pred.test(node)) {
                rsl = Optional.of(node);
                break;
            }
            list.addAll(node.children);
        }
        return rsl;
    }
}