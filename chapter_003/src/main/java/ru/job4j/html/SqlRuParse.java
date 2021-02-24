package ru.job4j.html;

import org.apache.commons.collections.map.HashedMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.LocalDateTime;
import java.util.Map;

public class SqlRuParse {
    public static void main(String[] args) throws Exception {
        ParseDate ps = new ParseDate();
        Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers").get();
        Elements rowsHrefs = doc.select(".postslisttopic");
        Elements rowsDates = doc.select(".altCol");
        int i = 1;
        for (Element el : rowsHrefs) {
            Element date = rowsDates.get(i);
            i += 2;
            System.out.println(el.attr("href"));
            System.out.println(el.text());
            System.out.println(date.text());
            System.out.println(ps.parse(date.text()));
        }
    }
}