package com.softeq.avizhen.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

/**
 * Created by Александр on 05.01.2021.
 */
public class WebCrawlerWithDeep {
    private static final int MAX_DEEP = 2;
    private HashSet<String> linksDeep = new HashSet<String>();

    public void  getPageLinks(String URL, int depth) {
        if ((!linksDeep.contains(URL) && (depth < MAX_DEEP))) {
            System.out.println("Depth:" + depth + "[" + URL + "]");
            linksDeep.add(URL);
            try {
                Document document = Jsoup.connect(URL).get();
                Elements linksOnPage = document.select("a[href]");
                depth++;
                for (Element page : linksOnPage) {
                    getPageLinks(page.attr("abs href"), depth);
                }
             } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
