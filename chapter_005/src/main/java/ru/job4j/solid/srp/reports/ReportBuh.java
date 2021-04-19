package ru.job4j.solid.srp.reports;

import java.util.function.Predicate;

public class ReportBuh implements Report {
    Store store;

    public ReportBuh(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary in dollars;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() / 70).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
