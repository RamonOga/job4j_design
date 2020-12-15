package ru.job4j.collection.mail;

import java.util.ArrayList;
import java.util.List;

public class MailUser {
     private List<String> mailList = new ArrayList<>();
     private String name;

    public MailUser(String name) {
        this.name = name;
        this.mailList = new ArrayList<>();
    }

    public void addMail(String mail) {
        if (mail != null) {
            mailList.add(mail);
        }
    }

    public List<String> getMailList() {
        return mailList;
    }

    public String getName() {
        return name;
    }
}
