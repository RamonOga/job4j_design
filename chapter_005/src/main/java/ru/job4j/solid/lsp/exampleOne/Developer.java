package ru.job4j.solid.lsp.exampleOne;

import java.util.Calendar;

public class Developer {
    private int salary;

    public Developer(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void writeCode() {
        if (this.salary <= 0) {
            throw new IllegalArgumentException("Salary cannot be less by zero!");
        }
        System.out.println("Write code!");
    }
}
