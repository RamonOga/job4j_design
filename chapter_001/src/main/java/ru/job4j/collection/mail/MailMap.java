
package ru.job4j.collection.mail;

import java.util.*;

public class MailMap {
    private Map<String, String> checkMap = new HashMap<>();
    private Map<String, Set<String>> mailMap = new HashMap<>();

    public void addUser(MailUser u) {
        String userName = u.getName();
        List<String> list = u.getMailList();
        Set<String> tmpSet = new HashSet<>();
        for (String email : list) {
            String user = checkMap.put(email, userName);
         if (user != null) {
             userName = user;
         }
         tmpSet.add(email);
     }
        if (mailMap.get(userName) == null) {
            mailMap.put(userName, tmpSet);
        } else {
            mailMap.get(userName).addAll(tmpSet);
        }
    }

    public List<MailUser> addAll(List<MailUser> list) {
        List<MailUser> rsl = new ArrayList<>();
        MailMap mailMap = new MailMap();
        for (MailUser mu : list) {
            mailMap.addUser(mu);
        }
        for (String s : mailMap.getMailMap().keySet()) {
            rsl.add(new MailUser(s, new ArrayList<>(mailMap.getMailMap().get(s))));
        }

        return rsl;
    }

    public Map<String, Set<String>> getMailMap() {
        return mailMap;
    }
}

