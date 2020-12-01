package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, T> implements Iterable<K> {
    private int tableSize;
    private int size;
    private NodeMap[] table;

    public SimpleHashMap() {
        table = new NodeMap[16];
        tableSize = 16;
    }

    public int tableSize() {
        return tableSize;
    }

    public int size() {
        return size;
    }

    public int hash(Object o) {
        return o.hashCode() & (tableSize - 1);
    }

    private void arraySizeUp() {
        NodeMap<K, T>[] tmp = table;
        NodeMap<K, T> node;
        table = new NodeMap[tableSize * 2];
        tableSize *= 2;
        size = 0;
       for (int i = 0; i < tmp.length; i++) {
           if (tmp[i] != null) {
               node = tmp[i];
               this.insert(node.key, node.value);
           }
       }
    }

    public boolean insert(K key, T value) {
        if ((int) ((size + 1) * 2) >= tableSize) {
            arraySizeUp();
        }
        int index = hash(key);
        if (table[index] != null) {
            return false;
        }
        table[index] = new NodeMap<K, T>(key, value, null, key.hashCode());
        size++;
        return true;
    }

    public T get(K key) {
        int index = hash(key);
        if (table[index] == null) {
            return null;
        }
        return (T) table[index].value;
    }

    public boolean delete(K key) {
        int index = hash(key);
        if (table[index] == null
                || table[index].hash != key.hashCode()) {
            return false;
        }
        table[index] = null;
        size--;
        return true;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            NodeMap<K, T> node;
            int iterCount = 0;

            @Override
            public boolean hasNext() {
                while (table[iterCount] == null
                        && iterCount < table.length - 1) {
                    iterCount++;
                }
                return table[iterCount] != null;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (K) table[iterCount++].key;
            }
        };
    }
}
