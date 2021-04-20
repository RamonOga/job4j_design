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
        for (Employee employee : store.findBy(filter)) {
            try(StringWriter sw = new StringWriter()) {
                JAXBContext context = JAXBContext.newInstance(Employee.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(employee, sw);
                rsl.append(sw.getBuffer().toString());
            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
        return rsl.toString();
    }
}
