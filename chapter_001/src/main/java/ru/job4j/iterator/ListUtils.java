package ru.job4j.iterator;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> it = list.listIterator();
        while (it.hasNext()) {
            if (it.nextIndex() == index) {
                it.add(value);
                break;
            }
            it.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> it = list.listIterator();
        while (it.hasNext()) {
            if (it.nextIndex() == index) {
                it.next();
                it.add(value);
                break;
            }
            it.next();
        }
    }

    public static <T> List<T> removeIf(List<T> list, Predicate<T> filter) {
        ListIterator it = list.listIterator();
        while (it.hasNext()) {
            Object t = it.next();
            if (!filter.test((T) t)) {
                it.remove();
            }
        }
        return list;
    }

    public static <T> List<T> replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator it = list.listIterator();
        while (it.hasNext()) {
            Object t = it.next();
            if (!filter.test((T) t)) {
                it.set(value);
            }
        }
        return list;
    }

    public static <T> List<T> removeAll(List<T> list, List<T> elements) {
        Iterator<T> listIt = list.listIterator();
        while (listIt.hasNext()) {
          if (elements.contains(listIt.next())) {
              listIt.remove();
          }
        }
        return list;
    }

}