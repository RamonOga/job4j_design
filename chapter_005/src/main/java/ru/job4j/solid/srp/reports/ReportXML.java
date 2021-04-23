package ru.job4j.solid.srp.reports;

import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.function.Predicate;

public class ReportXML implements Report {
    private Store store;

    public ReportXML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder rsl = new StringBuilder();
        Employees employees = new Employees(store.findBy(filter));
            try(StringWriter sw = new StringWriter()) {
                JAXBContext context = JAXBContext.newInstance(Employees.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(employees, sw);
                rsl.append(sw.toString());
            } catch (Exception e) {
                System.out.println(e.fillInStackTrace());
            }

        return rsl.toString();
    }
}
