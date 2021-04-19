package ru.job4j.solid.ocp.exampleOne;

import java.util.List;

public class WebSite {
    List<JavaDeveloper> javaDeveloperList;
    List<JSDeveloper> jsDeveloperList;

    public void production() {
        while (true) {
            for (JavaDeveloper jd : javaDeveloperList) {
                jd.writeJavaCode();
            }
            for (JSDeveloper jsd : jsDeveloperList) {
                jsd.writeJSCode();
            }
        }
    }
}
