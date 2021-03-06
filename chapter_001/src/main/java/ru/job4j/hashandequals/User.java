package ru.job4j.hashandequals;

import java.util.Calendar;
import java.util.Objects;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public User(String name, int children) {
        this.name = name;
        this.children = children;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", children=" + children
                + ", birthday=" + birthday
                + '}';
    }

    @Override
    public int hashCode() {
        int rsl = 1;

        rsl =   Integer.hashCode(children);
        rsl = 31 * rsl + name.hashCode();
        rsl = 31 * rsl + birthday.hashCode();
        //int rsl = Objects.hash(name, children, birthday);
       //System.out.println(rsl);
        return rsl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children
                 && Objects.equals(name, user.name)
                 && Objects.equals(birthday, user.birthday);
    }

    public String getName() {
        return name;
    }

    public int getChildren() {
        return children;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChildren(int children) {
        this.children = children;
    }
}
