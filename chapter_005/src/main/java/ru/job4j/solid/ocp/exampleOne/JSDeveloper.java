package ru.job4j.solid.ocp.exampleOne;

public class JSDeveloper {
    private int age;
    private String name;
    private int skill;

    public JSDeveloper(int age, String name, int skill) {
        this.age = age;
        this.name = name;
        this.skill = skill;
    }

    public void writeJSCode() {
        System.out.println("Write JS code.");
    }
}
