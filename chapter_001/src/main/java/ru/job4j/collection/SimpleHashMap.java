package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleHashMap<K, T> implements Iterable<ForwardLinkedForMap<K, T>> {
    private int arraySize;
    private int size;
    private ForwardLinkedForMap<K, T>[] table;

    public SimpleHashMap() {
        this.table = new ForwardLinkedForMap[16];
        this.arraySize = 16;
    }

    public int size() {
        return size;
    }

    public int hash(Object o) {
        return o.hashCode() & (arraySize - 1);
    }

    public boolean insert(K key, T value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new ForwardLinkedForMap<>();
        }
        NodeMap<K, T> node = table[index].getHead();
        if (node != null) {
            while (node != null) {
                if (node.hash == key.hashCode()) {
                    if (Objects.equals(node.key, key)) {
                        return false;
                    }
                }
                node = node.next;
            }
        }
        table[index].add(key, value, key.hashCode());
        size++;
        return true;
    }

    public T get(K key) {
        int index = hash(key);
        if (table[index] == null) {
            return null;
        }
        NodeMap<K, T> node = table[index].getHead();
        while (node != null) {
            if (node.hash == key.hashCode()) {
               if (Objects.equals(node.key, key)) {
                   return node.value;
               }
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public Iterator<ForwardLinkedForMap<K, T>> iterator() {
        return new Iterator<ForwardLinkedForMap<K, T>>() {
            int iterCount;
            @Override
            public boolean hasNext() {
                return iterCount < table.length;
            }

            @Override
            public ForwardLinkedForMap<K, T> next() {
                return table[iterCount++];
            }
        };
    }
}
