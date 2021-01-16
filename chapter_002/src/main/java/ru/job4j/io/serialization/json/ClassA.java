package ru.job4j.io.serialization.json;

import org.json.JSONPropertyIgnore;

public class ClassA {
    private ClassB b;

    @JSONPropertyIgnore
    public ClassB getB() {
        return b;
    }

    public void setB(ClassB b) {
        this.b = b;
    }
}
