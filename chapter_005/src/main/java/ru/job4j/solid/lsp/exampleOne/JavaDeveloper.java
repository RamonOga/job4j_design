package ru.job4j.solid.lsp.exampleone;

import java.util.Calendar;

public class JavaDeveloper extends Developer {

    public JavaDeveloper(int salary) {
        super(salary);
    }

    @Override
    public void writeCode() {
        int now = Calendar.getInstance().getTime().getHours();
        System.out.println(now);
        if (this.getSalary() <= 0 || now > 17 || now < 8) {
            throw new IllegalArgumentException("Salary cannot be less by zero!");
        }

        System.out.println("Write java code!");
    }
}
