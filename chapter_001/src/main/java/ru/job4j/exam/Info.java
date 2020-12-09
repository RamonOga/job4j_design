package ru.job4j.exam;

import org.apache.velocity.runtime.directive.Evaluate;

import java.util.Objects;

public class Info {
    private int added;
    private int changed;
    private int deleted;

    public void toAdd(int value) {
        added += value;
    }

    public void toChange(int value) {
        changed += value;
    }

    public void toDeleted(int value) {
        deleted += value;
    }

    @Override
    public int hashCode() {
        int rsl = 1; // for what?
        rsl = Integer.hashCode(added);
        rsl = 31 * rsl + Integer.hashCode(changed);
        rsl = 31 * rsl + Integer.hashCode(deleted);
        return rsl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return added == info.added &&
                changed == info.changed &&
                deleted == info.deleted;
    }

    public int getAdded() {
        return added;
    }

    public int getChanged() {
        return changed;
    }

    public int getDeleted() {
        return deleted;
    }
}
