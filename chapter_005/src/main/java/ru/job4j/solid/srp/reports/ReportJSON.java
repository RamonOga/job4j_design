package ru.job4j.solid.srp.reports;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class ReportJSON implements Report {
    private Store store;

    public ReportJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();

        for (Employee employee: store.findBy(filter)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", employee.getName());
            jsonObject.put("hired", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(employee.getHired().getTime()));
            jsonObject.put("fired", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(employee.getHired().getTime()));
            jsonObject.put("salary", employee.getSalary());
            text.append(jsonObject.toString());
            text.append(System.lineSeparator());
        }
        return text.toString();
    }
}

    /*JSONObject jsonObject = new JSONObject(employee);
            text.append(jsonObject.toString());
                    text.append(System.lineSeparator());*/