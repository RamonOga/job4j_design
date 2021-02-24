package ru.job4j.html;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

public class ParseDate {
    Map<String, String> months;

    public ParseDate() {
        init();
    }

    private void init() {
        months = new HashedMap();
        months.put("янв", "01");
        months.put("фев", "02");
        months.put("мар", "03");
        months.put("апр", "04");
        months.put("май", "05");
        months.put("июн", "06");
        months.put("июл", "07");
        months.put("авг", "08");
        months.put("сен", "09");
        months.put("окт", "10");
        months.put("ноя", "11");
        months.put("дек", "12");

    }
}
