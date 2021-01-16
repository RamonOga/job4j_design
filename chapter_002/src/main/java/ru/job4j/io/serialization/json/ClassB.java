package ru.job4j.io.serialization.json;

import org.json.JSONObject;

public class ClassB {
    private ClassA a;

    public ClassA getA() {
        return a;
    }

    public void setA(ClassA a) {
        this.a = a;
    }

    public static void main(String[] args) {
        ClassA a = new ClassA();
        ClassB b = new ClassB();
        a.setB(b);
        b.setA(a);

        System.out.println(new JSONObject(b));
    }
}
