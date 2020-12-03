package ru.job4j.collection;

import ru.job4j.generics.Predator;

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
                return !node.children.isEmpty() && node.children.size() > 2;
            }
        };
        Optional<Node<E>> rsl = xzMethod(pred);
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
       rsl = xzMethod(pred);
       return rsl;
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> op = findBy(parent);
        if (op.isPresent()) {
            Node<E> node = op.get();
            if (!node.children.contains(child)) {
                  node.children.add(new Node<E>(child));
                  rsl = true;
            }
        }
        return rsl;
    }

    public Optional<Node<E>> xzMethod(Predicate<Node<E>> pred) {
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

  /*Node<E> node;
        List<Node<E>> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            node = list.remove(0);
            if (!node.children.isEmpty() && node.children.size() > 2) {
                rsl = false;
                break;
            }
            list.addAll(node.children);
        }

         Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;*/