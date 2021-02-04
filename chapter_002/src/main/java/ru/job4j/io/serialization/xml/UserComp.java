package ru.job4j.io.serialization.xml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Arrays;

@XmlRootElement(name = "UserComp")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserComp {
    @XmlAttribute
    private String ip;
    private int timeOut;
    private boolean toTrace;
    private OS os;
    @XmlElementWrapper(name = "programs")
    @XmlElement(name = "program")
    private String[] programs;

    public UserComp() {

    }

    public UserComp(String ip, int timeOut, boolean toTrace, OS os, String... programs) {
        this.ip = ip;
        this.timeOut = timeOut;
        this.toTrace = toTrace;
        this.os = os;
        this.programs = programs;
    }

    @Override
    public String toString() {
        return "UserComp{"
                + "ip='" + ip + '\''
                + ", timeOut=" + timeOut
                + ", toTrace=" + toTrace
                + ", os=" + os
                + ", programs=" + Arrays.toString(programs)
                + '}';
    }
}
