package ru.job4j.collection;

import java.util.LinkedList;

import java.util.*;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean isBinary() {
        boolean rsl = true;
        Node<E> node;
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

    @Override
    public Optional<Node<E>> findBy(E value) {
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
        return rsl;
    }
}