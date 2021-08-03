package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Node;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Scraper {
    public List<String> healthList = new ArrayList<>();

    public Scraper() {
    }

    public List<String> getHealth() throws IOException {
        Document document = Jsoup.connect("https://vnexpress.net/suc-khoe").get();
        healthList = document.select("h3 > a[href$=.html]")
                    .stream().map(p -> p.attr("abs:href"))
                    .collect(Collectors.toList());
        return healthList;
    }

//    public News getVENews(String link) throws IOException {
//        News news = new News();
//        Document document = Jsoup.connect(link).get();
//        document.childNodes()
//                .stream()
//                .filter(node -> node instanceof DocumentType)
//                .findFirst()
//                .ifPresent(Node::remove);
//        String title = document.getElementsByClass("title-detail").text();
//        String summary = document.select("p.description").text();
//        String timeline = document.getElementsByClass("date").text();
//        String imgUrl = document.select("img").attr("data-src");
//        news.setTitle(title);
//        news.setPubDate(timeline);
//        news.setLink(link);
//        news.setSummary(summary);
//        if (imgUrl != null) {
//            news.setImage(imgUrl);
//        }
//        return news;
//    }
}

//        for (String link : sectionList) {
//            Document document = Jsoup.connect("https://vnexpress.net/sieu-thi-tp-hcm-dong-cua-som-4330708.html").get();
//            String title = document.getElementsByClass("title-detail").text();
//            String summary = document.select("p.description").text();
//            String content = document.select("article.fck_detail > p").text();
//            news.setDescription(summary);
//            news.setImageUrl(imgUrl);
//            news.setTitle(title);
//            news.setPubDate(timeline);
//            news.setContent(content);
//            newsList.add(news);
//        String body = content.text();
//        Element content = document.select("article").first();
//        List<String> imgUrl = document.select("img[src]")
//                              .stream().map(p -> p.attr("data-src"))
//                              .filter(String -> !String.trim().isEmpty())
//                              .collect(Collectors.toList());

