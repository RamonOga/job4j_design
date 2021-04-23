package ru.job4j.solid.lsp.exampleThree;

public class Developer {
    int skill;

    public Developer(int skill) {
        if (skill < 10) {
            throw new IllegalArgumentException("Skill cannot be less then 10");
        }
        this.skill = skill;
    }

    public Developer() {
    }
}
