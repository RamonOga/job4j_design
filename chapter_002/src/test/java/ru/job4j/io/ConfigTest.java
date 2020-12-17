package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "C:/projects/job4j_design/chapter_002/data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name1"),
                is("Roman Markelov")
        );
    }
}