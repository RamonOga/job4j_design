package ru.job4j.exam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AnalizeTest {
    List<User> users1;
    List<User> users2;

    @Before
    public void createUsersLists() {
        User user1 = new User(1, "java");
        User user2 = new User(2, "kotlin");
        User user3 = new User(3, "js");
        users1 = new ArrayList<>(List.of(user1, user2, user3)
        );
        users2 = new ArrayList<>(List.of(user1.copy(), user2.copy(), user3.copy())
        );
    }

    @Test
    public void testWhenNotChanges() {
        Analize anal = new Analize();
        Info info = anal.diff(users1, users2);
        Assert.assertEquals(0, info.hashCode());
    }

    @Test
    public void testWhenOneAdded() {
        Analize anal = new Analize();
        users2.add(new User(4, "c++"));
        Info info = anal.diff(users1, users2);
        Assert.assertEquals(1, info.getAdded());
    }

    @Test
    public void testWhenOneAdded2() {
        Analize anal = new Analize();
        users2.add(new User(4, "c++"));
        users2.add(new User(5, "c#"));
        Info info = anal.diff(users1, users2);
        Assert.assertEquals(2, info.getAdded());
    }

    @Test
    public void testWhenNullAdded() {
        Analize anal = new Analize();
        Info info = anal.diff(users1, users2);
        Assert.assertEquals(0, info.getAdded());
    }

    @Test
    public void testWhenOneChanged() {
        Analize anal = new Analize();
        users2.get(2).setName("Java Script");
        Info info = anal.diff(users1, users2);
        Assert.assertEquals(1, info.getChanged());
    }

    @Test
    public void testWhenOneDeleted() {
        Analize anal = new Analize();
        users2.remove(2);
        Info info = anal.diff(users1, users2);
        Assert.assertEquals(1, info.getDeleted());
    }
}