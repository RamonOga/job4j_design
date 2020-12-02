package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2));
        ListUtils.addAfter(input, 1, 3);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        assertThat(Arrays.asList(2, 4, 6, 8, 10),
                Is.is(ListUtils.removeIf(input, (a -> a % 2 == 1))));
    }

    @Test
    public void whenReplaceIf() {
        List<String> input = new ArrayList<>(Arrays.asList("java", "js",
                "kotlin", "c++", "cobol",
                "c#", "delphi", "php",
                "python", "css"));
        assertThat(Arrays.asList("JAVA!!!", "js",
                "kotlin", "c++", "cobol",
                "c#", "delphi", "php",
                 "python", "css"),
                 Is.is(ListUtils.replaceIf(input, (a -> a.equals("java")), "JAVA!!!")));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> input2 = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        assertThat(Arrays.asList(2, 4, 6, 8, 10),
                Is.is(ListUtils.removeAll(input1, input2)));
    }
}