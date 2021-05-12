package ru.job4j.solid.dip.exampleone;

import java.util.ArrayList;
import java.util.List;

public class WebApp {

    Service service;
    List<List<String>> webSiteCode;


    public WebApp(Service service) {
        this.service = service;
    }

    public boolean CreateWebSite() {
        return webSiteCode
                .add(service
                        .doWork(new ArrayList<>()));
    }
}
