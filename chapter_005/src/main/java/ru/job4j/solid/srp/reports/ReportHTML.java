package ru.job4j.solid.srp.reports;

import java.util.function.Predicate;

public class ReportHTML implements Report{
    Store store;

    public ReportHTML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<head>")
                .append("Name; Hired; Fired; Salary;")
                .append("</head>")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append("<body>")
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append("</body>")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
