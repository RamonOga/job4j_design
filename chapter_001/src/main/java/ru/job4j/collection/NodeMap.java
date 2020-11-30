package ru.job4j.collection;

public class NodeMap<K, T> {
    K key;
    T value;
    int hash;
    NodeMap<K, T> next;

    public NodeMap(K key, T value, NodeMap<K, T> next, int hash) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.hash = hash;
    }
}
