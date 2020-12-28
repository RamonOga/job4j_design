package ru.job4j.io;

import java.util.Objects;

public class FileDubleData implements Comparable<FileDubleData> {
    String name;
    Long size;

    public FileDubleData(String name, Long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int compareTo(FileDubleData o) {
        return this.size.compareTo(o.size);
    }

    /*@Override
    public int hashCode() {
        int rsl = 1;
        rsl = 31 * rsl + name.hashCode();
        rsl = 31 * rsl + size.hashCode();
        return rsl;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FileDubleData tmp = (FileDubleData) o;

        if (this.size.equals(tmp.size)
                && this.name.equals(tmp.name)) {
            return true;
        }
        return false;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileDubleData that = (FileDubleData) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }
}
