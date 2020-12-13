package ru.job4j.exam;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
      Info info = new Info();
      int count = 0;
      Map<Integer, User> map = previous.stream()
              .collect(Collectors.toMap(User::getId, user -> user));
        for (User u : current) {
            User tmp = map.get(u.getId());
            if (tmp == null) {
                info.toAdd(1);
                continue;
            }
            if (!tmp.equals(u)) {
            info.toChange(1);
            }
            count++;
        }
info.toDeleted(map.size() - count);
      return info;
    }
}
