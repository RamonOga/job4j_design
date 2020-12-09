package ru.job4j.exam;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        info.toDeleted(findMain(previous, current));
        info.toAdd(findMain(current, previous));
        findChange(previous, current, info);
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

    private void findChange(List<User> previous, List<User> current, Info info) {
        for (User u1 : previous) {
            for (User u2 : current) {
                if (u1.equals(u2)) {
                    if (!Objects.equals(u1.getName(), u2.getName())) {
                        info.toChange(1);
                        break;
                    }
                }
            }

        }
    }
}
