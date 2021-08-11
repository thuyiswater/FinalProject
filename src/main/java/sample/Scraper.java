package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Scraper {
    public List<String> healthList = new ArrayList<>();
    public List<String> hotList = new ArrayList<>();
    public List<String> covidList = new ArrayList<>();
    public List<String> politicsList = new ArrayList<>();
    public List<String> businessList = new ArrayList<>();
    public List<String> worldList = new ArrayList<>();
    public List<String> othersList = new ArrayList<>();
    public List<String> techList = new ArrayList<>();
    public List<String> entertainmentList = new ArrayList<>();
    public List<String> sportsList = new ArrayList<>();
//    String[] healthSection = {"https://vnexpress.net/suc-khoe", "https://thanhnien.vn/the-thao/",
//            "https://tuoitre.vn/the-thao.htm", "https://zingnews.vn/suc-khoe.html", "https://nhandan.vn/thethao"};
    public Scraper() {
    }

    public List<String> getHealth() throws IOException {
        Document document = Jsoup.connect("https://vnexpress.net/suc-khoe").get();
        healthList = document.select("h3 > a[href$=.html]")
                    .stream().map(p -> p.attr("abs:href"))
                    .limit(10)
                    .collect(Collectors.toList());
        return healthList;
    }

    public List<String> getNew() throws IOException {
        Document document = Jsoup.connect("https://vnexpress.net/tin-tuc-24h").get();
        hotList = document.select("h3 > a[href$=.html]")
                    .stream().map(p -> p.attr("abs:href"))
                    .limit(10)
                    .collect(Collectors.toList());
        return hotList;
    }

    public List<String> getCovid() throws IOException {
        Document document = Jsoup.connect("https://vnexpress.net/goc-nhin/covid-19").get();
        covidList = document.select("h3 > a[href$=.html]")
                    .stream().map(p -> p.attr("abs:href"))
                    .limit(10)
                    .collect(Collectors.toList());
        return covidList;
    }

    public List<String> getPolitics() throws IOException {
        Document document = Jsoup.connect("https://vnexpress.net/phap-luat").get();
        politicsList = document.select("h3 > a[href$=.html]")
                    .stream().map(p -> p.attr("abs:href"))
                    .limit(10)
                    .collect(Collectors.toList());
        return politicsList;
    }

    public List<String> getBusiness() throws IOException {
        Document document = Jsoup.connect("https://vnexpress.net/kinh-doanh").get();
        businessList = document.select("h3 > a[href$=.html]")
                    .stream().map(p -> p.attr("abs:href"))
                    .limit(10)
                    .collect(Collectors.toList());
        return businessList;
    }

    public List<String> getOthers() throws IOException {
        Document document = Jsoup.connect("https://vnexpress.net/oto-xe-may").get();
        othersList = document.select("h3 > a[href$=.html]")
                    .stream().map(p -> p.attr("abs:href"))
                    .limit(10)
                    .collect(Collectors.toList());
        return othersList;
    }

    public List<String> getTech() throws IOException {
        Document document = Jsoup.connect("https://vnexpress.net/so-hoa").get();
        techList = document.select("h3 > a[href$=.html]")
                    .stream().map(p -> p.attr("abs:href"))
                    .limit(10)
                    .collect(Collectors.toList());
        return techList;
    }

    public List<String> getEntertainment() throws IOException {
        Document document = Jsoup.connect("https://vnexpress.net/giai-tri").get();
        entertainmentList = document.select("h3 > a[href$=.html]")
                    .stream().map(p -> p.attr("abs:href"))
                    .limit(10)
                    .collect(Collectors.toList());
        return entertainmentList;
    }

    public List<String> getWorld() throws IOException {
        Document document = Jsoup.connect("https://vnexpress.net/the-gioi").get();
        worldList = document.select("h3 > a[href$=.html]")
                    .stream().map(p -> p.attr("abs:href"))
                    .limit(10)
                    .collect(Collectors.toList());
        return worldList;
    }

    public List<String> getSports() throws IOException {
        Document document = Jsoup.connect("https://vnexpress.net/the-thao").get();
        sportsList = document.select("h3 > a[href$=.html]")
                    .stream().map(p -> p.attr("abs:href"))
                    .limit(10)
                    .collect(Collectors.toList());
        return sportsList;
    }
}

//        Document document = Jsoup.connect("https://thanhnien.vn/the-thao/").get();
//        healthList = document.select("h2 > a[href$=.html]")
//                .stream().map(p -> p.attr("abs:href"))
//                .limit(10)
//                .collect(Collectors.toList());
//        Document document = Jsoup.connect("https://tuoitre.vn/the-thao.htm").get();
//        healthList = document.select("h2 > a[href$=.html]")
//                .stream().map(p -> p.attr("abs:href"))
//                .limit(10)
//                .collect(Collectors.toList());
//        Document document = Jsoup.connect("https://zingnews.vn/suc-khoe.html").get();
//        healthList = document.select("h2 > a[href$=.html]")
//                .stream().map(p -> p.attr("abs:href"))
//                .limit(10)
//                .collect(Collectors.toList());


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

//        for (String link : sectionList) {
//            Document = Jsoup.connect("https://vnexpress.net/sieu-thi-tp-hcm-dong-cua-som-4330708.html").get();
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

