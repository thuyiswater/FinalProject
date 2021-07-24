package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Scraper {
    private ArrayList<News> newsList = new ArrayList<>();
    News news = new News();
    public Scraper() {
    }

    public ArrayList<News> getVENews(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        String title = document.getElementsByClass("title-detail").text();
        String summary = document.select("p.description").text();
        String content = document.select("article.fck_detail > p").text();
        String timeline = document.getElementsByClass("date").text();
        List<String> imgUrl = document.select("img[src]")
                                .stream().map(p -> p.attr("data-src"))
                                .collect(Collectors.toList());
        news.setDescription(summary);
        news.setImageUrl(imgUrl);
        news.setTitle(title);
        news.setPubDate(timeline);
        news.setContent(content);
        newsList.add(news);
        return newsList;
    }

    public void getZingNews(String url) throws IOException {
        Document doc = Jsoup.connect(url).timeout(6000).get();
        System.out.print(doc.getElementsByClass("the-article-title").text());
        System.out.println(doc.getElementsByClass("description").text());
        System.out.println(doc.getElementsByClass("the-article-credit").first().text());
        System.out.println(doc.getElementsByTag("p").text());
        System.out.println(doc.getElementsByTag("img").attr("data-src"));
        System.out.println(doc.getElementsByClass("the-article-publish").text());
    }

    public void getNDNews(String url) throws IOException {
        Document doc = Jsoup.connect(url).timeout(6000).get();
        System.out.println(doc.getElementsByClass("box-title-detail entry-title").text());
        System.out.println(doc.getElementsByClass("box-date pull-left").text());
        System.out.println(doc.getElementsByClass("box-detail-thumb uk-text-center").attr("img", "src"));
        System.out.println(doc.getElementsByClass("box-detail-thumb uk-text-center").tagName("img").text());
        System.out.println(doc.getElementsByClass("detail-content-body").text());
        System.out.println(doc.getElementsByClass("box-author uk-text-right uk-clearfix").text());
    }

    public void getTNNews(String url) throws IOException {
        Document doc = Jsoup.connect(url).timeout(6000).get();
        System.out.println(doc.getElementsByClass("details__headline").text());
        System.out.println(doc.getElementsByClass("cms-body detail").tagName("div").text());
        System.out.println(doc.getElementsByClass("meta").tagName("time").text());
    }

    public void getTTNews(String url) throws IOException {
        Document doc = Jsoup.connect(url).timeout(6000).get();
        System.out.println(doc.getElementsByClass("article-title").text());
        System.out.println(doc.getElementsByTag("meta").attr("content"));
        System.out.println(doc.getElementById("main-detail-body").tagName("p").text());
        System.out.println(doc.getElementsByClass("date-time").text());
        System.out.println(doc.getElementsByClass("author").text());
    }
}

