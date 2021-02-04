package ru.job4j.io.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Runner {
    public static void main(String[] args) throws JAXBException {
        UserComp userComp = new UserComp(
                "192.168.1.1", 1000,
                true, new OS("win 7"),
                "word", "excel");
        String xml = marshaller(userComp);
        unMarshaller(xml);

    }

    public static String marshaller(UserComp userComp) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(UserComp.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(userComp, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml;
    }

    public static void unMarshaller(String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(UserComp.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            UserComp rsl = (UserComp) unmarshaller.unmarshal(reader);
            System.out.println(rsl);
        }
    }
}
