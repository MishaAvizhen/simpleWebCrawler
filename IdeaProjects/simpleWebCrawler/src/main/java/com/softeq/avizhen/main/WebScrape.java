package com.softeq.avizhen.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.*;


public class WebScrape {

    private static final Comparator<ResultDto> compareResultByCount = new Comparator<ResultDto>() {
        public int compare(ResultDto o1, ResultDto o2) {
            return o2.getCount() - o1.getCount();
        }
    };

    private static Document getPage() throws IOException {
        String url = "https://en.wikipedia.org/wiki/Tesla_Model_3";
        return Jsoup.parse(new URL(url), 3000);

    }

    public static void main(String[] args) throws IOException {

        Document page = getPage();
        Map<String, Integer> wordsMap = new TreeMap<String, Integer>();
        System.out.println("Enter number of word:");
        Scanner scanner = new Scanner(System.in);
        Integer numberOfWords = scanner.nextInt();
        for (int i = 0; i < numberOfWords; i++) {
            System.out.println("Enter word:");
            String wordToFind = scanner.next();
            wordsMap.put(wordToFind, 0);
        }

        Element words = page.select("div[id=bodyContent]").first();
        Elements allElementsUnderMainDiv = words.getAllElements();
        for (Element elementUnderMainDiv : allElementsUnderMainDiv) {
            String elementText = elementUnderMainDiv.text();
            for (Map.Entry<String, Integer> targetWordToCount : wordsMap.entrySet()) {
                boolean comapareWord = elementText.toLowerCase().contains(targetWordToCount.getKey().toLowerCase());
                if (comapareWord) {
                    Integer oldCount = targetWordToCount.getValue();
                    Integer newCount = oldCount + 1;
                    wordsMap.put(targetWordToCount.getKey(), newCount);
                }
            }
        }
        System.out.println(wordsMap);

        TreeSet<ResultDto> sortedResultByCount = new TreeSet(compareResultByCount);
        for (Map.Entry<String, Integer> integerEntry : wordsMap.entrySet()) {
            sortedResultByCount.add(new ResultDto(integerEntry.getKey(), integerEntry.getValue()));
        }
        System.out.println(sortedResultByCount);


        TreeSet<String> links = new TreeSet<String>();
        Elements elements = page.select("a[href]");
        for (Element refElements : elements) {
            links.add(refElements.attr("href"));


        }
        System.out.println(links.size());

    }




}




