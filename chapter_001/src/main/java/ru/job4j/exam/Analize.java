package ru.job4j.exam;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        info.toAdd(findMain(current, previous));
        find(previous, current, info);
        return info;
    }

    private int findMain(List<User> one, List<User> two) {
        int count = 0;
        for (User u : one) {
            if (!two.contains(u)) {
                count++;
            }
        }
        return count;
    }

    private void find(List<User> one, List<User> two, Info info) {
        for (User u : one) {
            int index = two.indexOf(u);
            if (index != -1) {
                if (!Objects.equals(u.getName(), two.get(index).getName())) {
                    info.toChange(1);
                    break;
                }
            } else {
                info.toDeleted(1);
            }
        }
    }
}
