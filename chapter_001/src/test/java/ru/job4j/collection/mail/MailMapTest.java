package ru.job4j.collection.mail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MailMapTest {
    MailUser user1 = new MailUser("user1");
    MailUser user2 = new MailUser("user1");
    MailUser user3 = new MailUser("user3");
    MailUser user4 = new MailUser("user1");
    MailUser user5 = new MailUser("user1");
    List<MailUser> userList = new ArrayList<>();

    @Before
    public void createUsers() {

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
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);

    }

    @Test
    public void addTest() {
        MailMap mailMap = new MailMap();
        mailMap.addUser(user1);
        mailMap.addUser(user2);
        mailMap.addUser(user3);
        mailMap.addUser(user4);
        mailMap.addUser(user5);
        Assert.assertEquals(2, mailMap.getMailMap().size());
    }

    @Test
    public void addAllTest() {
        MailMap mailMap = new MailMap();
        List<MailUser> list = mailMap.addAll(userList);
        Assert.assertTrue(list.get(0).getMailList().contains("aaa@bbb.ru"));
        Assert.assertTrue(list.get(0).getMailList().contains("ups@pisem.net"));
        Assert.assertTrue(list.get(0).getMailList().contains("lol@mail.ru"));
        Assert.assertTrue(list.get(0).getMailList().contains("xxx@ya.ru"));
        Assert.assertTrue(list.get(0).getMailList().contains("foo@gmail.com"));
        Assert.assertTrue(list.get(1).getMailList().contains("vasya@pupkin.com"));
        Assert.assertTrue(list.get(1).getMailList().contains("xyz@pisem.net"));

    }

    @Test
    public void test() {
        MailMap mailMap = new MailMap();
        mailMap.addUser(user1);
        mailMap.addUser(user2);
        mailMap.addUser(user3);
        mailMap.addUser(user4);
        mailMap.addUser(user5);
        System.out.println(mailMap.getMailMap());
    }
}
