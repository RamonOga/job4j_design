package ru.job4j.collection;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.is;

public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenMore3Children() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        Assert.assertFalse(tree.isBinary());
    }

    @Test
    public void whenAll2Children() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(4, 5);
        tree.add(4, 6);
        Assert.assertTrue(tree.isBinary());
    }

    @Test
    public void whenAddChildrenAlreadyHas() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 3);
        tree.add(1, 3);
        int expect = 1;
        Assert.assertEquals(expect, tree.findBy(1).get().children.size());
    }
}