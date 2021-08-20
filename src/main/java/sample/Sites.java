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
        String title = document.getElementsByClass("title-detail").text();
        String summary = document.select("p.description").text();
        String timeline = document.getElementsByClass("date").text();
        String imgUrl = document.select("img").attr("data-src");
        return new Article(title, summary, imgUrl, timeline, link);
    }

    public Article getZingNews(String link) throws IOException {
        Document document = Jsoup.connect(link).get();
        String title = document.getElementsByClass("the-article-title").text();
        String summary = document.select("p.the-article-summary").text();
        String timeline = document.select("li.the-article-publish").text();
        String imgUrl = document.select("img").attr("data-src");
        return new Article(title, summary, imgUrl, timeline, link);
    }

    public Article getThanhNien(String link) throws IOException {
        Document document = Jsoup.connect(link).get();
        String title = document.getElementsByClass("details__headline").text();
        String summary = document.select("div.sapo").text();
        String timeline = document.select(".details__meta time").text();
        String imgUrl = document.select(".pswp-content__wrapimage img").attr("abs:src");
        return new Article(title, summary, imgUrl, timeline, link);
    }

    public Article getTuoiTre(String link) throws IOException {
        Document document = Jsoup.connect(link).get();
        String title = document.getElementsByClass("article-title").text();
        String summary = document.select("h2.sapo").text();
        String timeline = document.getElementsByClass("date-time").text();
        String imgUrl = document.select(".VCSortableInPreviewMode img").attr("abs:src");
        return new Article(title, summary, imgUrl, timeline, link);
    }

    public Article getNhanDan(String link) throws IOException {
        Document document = Jsoup.connect(link).get();
        String title = document.getElementsByTag("h1").text();
        String summary = document.select("div.box-des-detail p").text();
        String timeline = document.select("div.box-date").text();
        String imgUrl = document.select(".entry-content img").attr("abs:src");
        return new Article(title, summary, imgUrl, timeline, link);
    }
}

//       document.childNodes()
////                .stream()
////                .filter(node -> node instanceof DocumentType)
////                .findFirst()
////                .ifPresent(Node::remove);
//System.out.println(title);
//System.out.println(summary);
//System.out.println(imgUrl);
//System.out.println(timeline);
//System.out.println(link);