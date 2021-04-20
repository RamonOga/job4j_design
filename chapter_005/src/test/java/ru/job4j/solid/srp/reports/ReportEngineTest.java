package ru.job4j.solid.srp.reports;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import net.sf.saxon.expr.Component;
import org.junit.Test;
import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        String expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator())
                .toString();
        assertEquals(expect,engine.generate(em -> true));
    }

    @Test
    public void whenHtmlGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportHTML(store);
        String expect = new StringBuilder()
                .append("<head>")
                .append("Name; Hired; Fired; Salary;")
                .append("</head>")
                .append(System.lineSeparator())
                .append("<body>")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append("</body>")
                .append(System.lineSeparator())
                .toString();
        assertEquals(expect,engine.generate(em -> true));
    }

    @Test
    public void whenBuhGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportBuh(store);
        String expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary in dollars;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()/70).append(";")
                .append(System.lineSeparator())
                .toString();
        assertEquals(expect,engine.generate(em -> true));
    }

    @Test
    public void whenHRGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Petr", now, now, 250);
        Employee worker2 = new Employee("Ivan", now, now, 100);
        store.add(worker1);
        store.add(worker2);
        Report engine = new ReportHR(store);
        String rsl = engine.generate(em -> true);
        String expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .toString();

        assertEquals(expect, rsl);
    }
}