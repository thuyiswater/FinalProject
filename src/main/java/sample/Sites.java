package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Node;

import java.io.IOException;

public class Sites {


    public Sites() {
    }

    public Article getVnExpress(String link) throws IOException {
        Document document = Jsoup.connect(link).get();
        document.childNodes()
                .stream()
                .filter(node -> node instanceof DocumentType)
                .findFirst()
                .ifPresent(Node::remove);
        String title = document.getElementsByClass("title-detail").text();
        String summary = document.select("p.description").text();
        String timeline = document.getElementsByClass("date").text();
        String imgUrl = document.select("img").attr("data-src");

        return new Article(title, summary, imgUrl, timeline, link);
    }

    public Article getZingNews(String link) throws IOException {
        Document document = Jsoup.connect(link).get();
        document.childNodes()
                .stream()
                .filter(node -> node instanceof DocumentType)
                .findFirst()
                .ifPresent(Node::remove);
        String title = document.getElementsByClass("the-article-title").text();
        String summary = document.select("the-article-summary").text();
        String timeline = document.getElementsByClass("the-article-publish").text();
        String imgUrl = document.select("img").attr("src");

        return new Article(title, summary, imgUrl, timeline, link);
    }

    public Article getThanhNien(String link) throws IOException {
        Document document = Jsoup.connect(link).get();
        document.childNodes()
                .stream()
                .filter(node -> node instanceof DocumentType)
                .findFirst()
                .ifPresent(Node::remove);
        String title = document.getElementsByClass("title-detail").text();
        String summary = document.select("p.description").text();
        String timeline = document.getElementsByClass("date").text();
        String imgUrl = document.select("img").attr("data-src");

        return new Article(title, summary, imgUrl, timeline, link);
    }

    public Article getTuoiTre(String link) throws IOException {
        Document document = Jsoup.connect(link).get();
        document.childNodes()
                .stream()
                .filter(node -> node instanceof DocumentType)
                .findFirst()
                .ifPresent(Node::remove);
        String title = document.getElementsByClass("title-detail").text();
        String summary = document.select("p.description").text();
        String timeline = document.getElementsByClass("date").text();
        String imgUrl = document.select("img").attr("data-src");

        return new Article(title, summary, imgUrl, timeline, link);
    }

    public Article getNhanDan(String link) throws IOException {
        Document document = Jsoup.connect(link).get();
        document.childNodes()
                .stream()
                .filter(node -> node instanceof DocumentType)
                .findFirst()
                .ifPresent(Node::remove);
        String title = document.getElementsByClass("title-detail").text();
        String summary = document.select("p.description").text();
        String timeline = document.getElementsByClass("date").text();
        String imgUrl = document.select("img").attr("data-src");

        return new Article(title, summary, imgUrl, timeline, link);
    }
}

//        article.setTitle(title);
//        article.setPubDate(timeline);
//        article.setLink(link);
//        article.setSummary(summary);
//        if (imgUrl != null) {
//            article.setImage(imgUrl);
//        }
//        return article;