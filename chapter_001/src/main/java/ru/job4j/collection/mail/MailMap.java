
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

    public Map<String, Set<String>> getMailMap() {
        return mailMap;
    }
}

