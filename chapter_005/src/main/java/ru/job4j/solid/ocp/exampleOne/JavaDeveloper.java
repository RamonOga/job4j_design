package ru.job4j.solid.ocp.exampleOne;

public class JavaDeveloper {
    private int age;
    private String name;
    private int skill;

    public JavaDeveloper(int age, String name, int skill) {
        this.age = age;
        this.name = name;
        this.skill = skill;
    }

    public void writeJavaCode() {
        System.out.println("Write java code.");
    }
}
