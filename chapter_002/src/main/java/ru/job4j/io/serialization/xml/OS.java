package ru.job4j.io.serialization.xml;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "OS")
public class OS {
    @XmlAttribute
    String value;

    public OS() {

    }

    public OS(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "OS{"
                + "value='" + value + '\''
                + '}';
    }
}
