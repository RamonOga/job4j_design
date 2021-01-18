package ru.job4j.it;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.NoSuchElementException;

public class BackwardArrayItTest {

    @Test
    public void whenMultiCallhasNextThenTrue() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[] {1, 2, 3}
        );
        assertTrue(it.hasNext());
        assertTrue(it.hasNext());
    }

    @Test
    public void whenReadSequence() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[] {1, 2, 3}
        );
        int rsl = it.next();
        assertEquals(3, rsl);
        rsl = it.next();
        assertEquals(2, rsl);
        rsl = it.next();
        assertEquals(1, rsl);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[] {}
        );
        it.next();
    }
}