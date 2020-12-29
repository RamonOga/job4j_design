package ru.job4j.io.duble;

import java.nio.file.Path;
import java.util.Objects;

public class FileDubleData implements Comparable<FileDubleData> {
    String name;
    Long size;
    Path path;

    public FileDubleData(Path path) {
        this.name = path.getFileName().toString();
        this.size = path.toFile().length();
        this.path = path;
    }

    @Override
    public int compareTo(FileDubleData o) {
        return this.size.compareTo(o.size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FileDubleData that = (FileDubleData) o;
        return Objects.equals(name, that.name)
                && Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }

    public Path getPath() {
        return path;
    }

    @Override
    public String toString() {
        String rsl = "file name is: " + name
                + " size: " + size
                + " full path of file: " + path;
        return rsl;
    }

}
