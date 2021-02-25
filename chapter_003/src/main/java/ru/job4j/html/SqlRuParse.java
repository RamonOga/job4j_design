package ru.job4j.html;

import org.apache.commons.collections.map.HashedMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SqlRuParse {
    public static void main(String[] args) throws Exception {
        for (String html : getHtmls(5)) {
            getVacancies(html);
        }


        }

    private static void getVacancies(String html) throws Exception {
        ParseDate ps = new ParseDate();
        Document doc = Jsoup.connect(html).get();
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

    private static List<String> getHtmls(int capacity) {
        String html = "https://www.sql.ru/forum/job-offers/";
        List<String> rsl = new ArrayList<>();
        for (int i = 1; i <= capacity; i++) {
            rsl.add(html + i);
        }
        return rsl;
    }
}