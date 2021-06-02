package ru.job4j.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int rsl = -1;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.computeIfPresent(nums[i], (key, value) -> value + 1);
            }

        }

        for (int i : map.keySet()) {
            if (map.get(i) == 1) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }
}
