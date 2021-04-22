package ru.job4j.solid.lsp.exampleOne;

import java.util.List;

public class Project {
    public void production(List<Developer> list) {
        while (true) {
            for (Developer dev : list) {
                dev.writeCode();
            }
        }
    }
}
