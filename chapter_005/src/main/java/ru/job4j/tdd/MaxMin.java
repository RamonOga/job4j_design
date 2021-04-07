package ru.job4j.tdd;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> maxPredicate = (a) -> (a < 0);
        return comp(value, comparator, maxPredicate);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> minPredicate = (a) -> (a > 0);
        return comp(value, comparator, minPredicate);
    }

    private <T> T comp(List<T> value, Comparator<T> comparator, Predicate<Integer> pred) {
        T rsl = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            T tmp = value.get(i);
            if (pred.test(comparator.compare(rsl, tmp))) {
                rsl = tmp;
            }
        }
        return rsl;
    }
}