package ru.job4j.solid.srp.reports;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import net.sf.saxon.expr.Component;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
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

    @Test
    public void whenXMLGenerated() {

        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee employee1 = new Employee("Petr", now, now, 100);
        store.add(employee1);
        Report engine = new ReportXML(store);
        String rsl = engine.generate(em -> true);
        String expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append(System.lineSeparator())
                .append("<Employee name=\"Petr\" hired=\"")
                .append(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(employee1.getHired().getTime()))
                .append("\" fired=\"")
                .append(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(employee1.getFired().getTime()))
                .append("\" salary=\"100.0\"/>")
                .append(System.lineSeparator())
                .toString();

        char[] expectChars = expect.toCharArray();
        char[] rslChars = rsl.toCharArray();
        System.out.println("======");
        System.out.println(expect);
        System.out.println("======");
        System.out.println(rsl);
        System.out.println("======");

        for (int i = 0; i != rslChars.length; i++) {
            if (rslChars[i] != expectChars[i]) {
                System.out.println("==================================");
                System.out.println("rsl=>" + (int) rslChars[i] + "<=rsl");
                System.out.println("exp=>" + (int) expectChars[i] + "<=exp");
                System.out.println("==================================");

            }
        }


        //assertEquals(expect, rsl);
    }

    @Test
    public void whenJSONGenerated() {
        //2021-04-20T15:06:05.963+03:00
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println(calendar);

        System.out.println(new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss.SSSXXX").format(calendar.getTime()));
    }
}