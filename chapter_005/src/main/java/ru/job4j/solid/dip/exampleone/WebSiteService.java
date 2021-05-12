package ru.job4j.solid.dip.exampleone;

import java.util.ArrayList;
import java.util.List;

public class WebSiteService implements Service {

    List<Developer> developers;

    public WebSiteService() {
        developers = new ArrayList<>();
    }

    @Override
    public boolean addDeveloper(Developer developer) {
        return developers.add(developer);
    }

    @Override
    public boolean removeDeveloper(Developer developer) {
       return developers.remove(developer);
    }

    @Override
    public List<String> doWork(List<String> workCode) {
        for (int i = 0; i < 1000000; i++) {
            for (Developer dev : developers) {
                workCode.add(dev.writeCode());
            }
        }
        return workCode;
    }
}
