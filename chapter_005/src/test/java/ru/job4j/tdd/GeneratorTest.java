package ru.job4j.tdd;

import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class GeneratorTest {

    @Test
    public void testProduce() {
        TextGenerator tg = new TextGenerator();
        String template = "I'd like a cap of {drink} and {eat}";
        String expected = "I'd like a cap of tea and cake";
        Map<String, String> args = new HashMap<>();
        args.put("drink", "tea");
        args.put("eat", "cake");
        assertEquals(expected, tg.produce(template, args));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProduceThenWrongKeys() {
        TextGenerator tg = new TextGenerator();
        String template = "I'd like a cap of {drink} and {eat}";
        Map<String, String> args = new HashMap<>();
        args.put("alcohol", "beer");
        args.put("snack", "chips");
    }

    @Test
    public void testProduceThenSoManyKeys() {
        TextGenerator tg = new TextGenerator();
        String template = "I'd like a cap of {drink} and {eat}";
        String expected = "I'd like a cap of tea and cake";
        Map<String, String> args = new HashMap<>();
        args.put("drink", "tea");
        args.put("eat", "cake");
        args.put("alcohol", "beer");
    }
}