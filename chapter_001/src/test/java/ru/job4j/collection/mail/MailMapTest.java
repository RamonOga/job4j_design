package ru.job4j.collection.mail;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MailMapTest {
    @Before
    public void createUsers() {

    }

    @Test
    public void addTest() {
        MailMap mailMap = new MailMap();
        MailUser user1 = new MailUser("user1");
        MailUser user2 = new MailUser("user1");
        MailUser user3 = new MailUser("user3");
        MailUser user4 = new MailUser("user1");
        MailUser user5 = new MailUser("user1");
        user1.addMail("xxx@ya.ru");
        user1.addMail("foo@gmail.com");
        user1.addMail("lol@mail.ru");
        user2.addMail("foo@gmail.com");
        user2.addMail("ups@pisem.net");
        user3.addMail("xyz@pisem.net");
        user3.addMail("vasya@pupkin.com");
        user4.addMail("ups@pisem.net");
        user4.addMail("aaa@bbb.ru");
        user5.addMail("xyz@pisem.net");
        mailMap.addUser(user1);
        mailMap.addUser(user2);
        mailMap.addUser(user3);
        mailMap.addUser(user4);
        mailMap.addUser(user5);
        System.out.println(mailMap.getMailMap());

    }

}

//user1 ->xxx@ya.ru,foo@gmail.com,lol@mail.ru
//user2 ->foo@gmail.com,ups@pisem.net
//user3 ->xyz@pisem.net,vasya@pupkin.com
//user4 ->ups@pisem.net,aaa@bbb.ru
//user5 ->xyz@pisem.net

//user1 ->xxx@ya.ru,foo@gmail.com,lol@mail.ru,ups@pisem.net,aaa@bbb.ru
//user3 ->xyz@pisem.net,vasya@pupkin.com