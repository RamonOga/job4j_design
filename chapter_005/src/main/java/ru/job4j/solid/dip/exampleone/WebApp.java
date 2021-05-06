package ru.job4j.solid.dip.exampleone;

import java.util.ArrayList;
import java.util.List;

public class WebApp {
    List<Developer> developers;

    public WebApp(List<Developer> developers) {
        this.developers = developers;
    }

    public List<String> work() {
        List<String> workList = new ArrayList<>();
        while(true) {
            for (Developer dev : developers) {
                workList.add(dev.writeCode());
            }
            return workList;
        }
    }
}
