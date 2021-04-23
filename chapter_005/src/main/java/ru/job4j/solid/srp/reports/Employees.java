package ru.job4j.solid.srp.reports;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {
    @XmlElement
    Employee[] employees;

    public Employees(List<Employee> list) {
        init(list);
    }

    public Employees() {}

    private void init(List<Employee> list) {
        if (list == null) {
            throw new IllegalArgumentException("input data cannot be null");
        }
        employees = new Employee[list.size()];

        for(int i = 0; i != list.size(); i++) {
            employees[i] = list.get(i);
        }
    }

    public Employee[] getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
