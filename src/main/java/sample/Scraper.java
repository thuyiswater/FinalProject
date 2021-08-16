package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Scraper {
    private List<String> healthList = new ArrayList<>();
    private List<String> covidList = new ArrayList<>();
    private List<String> politicsList = new ArrayList<>();
    private List<String> businessList = new ArrayList<>();
    private List<String> worldList = new ArrayList<>();
    private List<String> othersList = new ArrayList<>();
    private List<String> techList = new ArrayList<>();
    private List<String> entertainmentList = new ArrayList<>();
    private List<String> sportsList = new ArrayList<>();

    private final String[] healthSites = {"https://vnexpress.net/suc-khoe", "https://zingnews.vn/suc-khoe.html", "https://nhandan.vn/y-te",
            "https://tuoitre.vn/suc-khoe.htm", "https://thanhnien.vn/suc-khoe/"};
    private final String[] covidSites = {"https://vnexpress.net/goc-nhin/covid-19", "https://zingnews.vn/tieu-diem/covid-19-bung-phat-2021.html?src=home_trending",
            "https://nhandan.vn/tag/Covid19-53", "https://tuoitre.vn/covid-19.html", "https://thanhnien.vn/covid-19/"};
    private final String[] hotSites = {"https://vnexpress.net/tin-tuc-24h", "https://zingnews.vn/", "https://nhandan.vn/",
            "https://tuoitre.vn/", "https://thanhnien.vn/"};
    private final String[] politicsSites = {"https://vnexpress.net/phap-luat", "https://zingnews.vn/chinh-tri.html", "https://nhandan.vn/chinhtri",
            "https://tuoitre.vn/bo-chinh-tri.html", "https://thanhnien.vn/thoi-su/chinh-tri/"};
    private final String[] businessSites = {"https://vnexpress.net/kinh-doanh", "https://zingnews.vn/suc-khoe.html", "https://nhandan.vn/y-te",
            "https://tuoitre.vn/giai-tri.htm", "https://thanhnien.vn/suc-khoe/"};
    private final String[] worldSites = {"https://vnexpress.net/the-gioi", "https://zingnews.vn/the-gioi.html", "https://nhandan.vn/thegioi",
            "https://tuoitre.vn/the-gioi.htm", "https://thanhnien.vn/the-gioi/"};
    private final String[] techSites = {"https://vnexpress.net/so-hoa", "https://zingnews.vn/cong-nghe.html", "https://nhandan.vn/khoahoc-congnghe",
            "https://congnghe.tuoitre.vn/", "https://thanhnien.vn/cong-nghe/"};
    private final String[] entertainmentSites = {"https://vnexpress.net/giai-tri", "https://zingnews.vn/giai-tri.html", "https://nhandan.vn/giai-tri/",
            "https://tuoitre.vn/giai-tri.htm", "https://thanhnien.vn/giai-tri/"};
    private final String[] sportsSites = {"https://vnexpress.net/the-thao", "https://zingnews.vn/the-thao.html", "https://nhandan.vn/thethao",
            "https://tuoitre.vn/the-thao.htm", "https://thanhnien.vn/the-thao/"};
    private final String[] othersSites = {"https://vnexpress.net/oto-xe-may", "https://zingnews.vn/thoi-su.html", "https://nhandan.vn/du-lich",
            "https://dulich.tuoitre.vn/", "https://thanhnien.vn/du-lich/"};

    public Scraper() {
    }


    public List<String> getHealth() {
        List<String> health;
            for (String site : healthSites) {
                Document document = null;
                try {
                    assert false;
                    document = Jsoup.connect(site).get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (site.contains("express")) {
                    health = document.select("h3 > a[href$=.html]")
                            .stream().map(p -> p.attr("abs:href"))
                            .limit(10)
                            .collect(Collectors.toList());
                    healthList.addAll(health);
                } else if (site.contains("zingnews")) {
                    health = document.select("p.article-title > a[href$=.html]")
                            .stream().map(p -> p.attr("abs:href"))
                            .limit(10)
                            .collect(Collectors.toList());
                    healthList.addAll(health);
//                } else if (site.contains("nhandan")) {
//                    health = document.select("div.box-title > a[href]")
//                            .stream().map(p -> p.attr("abs:href"))
//                            .limit(10)
//                            .collect(Collectors.toList());
//                    healthList.addAll(health);
//                } else if (site.contains("tuoitre")) {
//                    health = document.select("h3.title-news > a[href$=.htm]")
//                            .stream().map(p -> p.attr("abs:href"))
//                            .limit(10)
//                            .collect(Collectors.toList());
//                    healthList.addAll(health);
//                } else {
//                    health = document.select("h2 > a[href$=.html]")
//                            .stream().map(p -> p.attr("abs:href"))
//                            .limit(10)
//                            .collect(Collectors.toList());
//                    healthList.addAll(health);
//                }
                }
            }
        return healthList;
    }

    public List<String> getNew() throws IOException {
        Document document = Jsoup.connect("https://vnexpress.net/tin-tuc-24h").get();
        List<String> hotList = document.select("h3 > a[href$=.html]")
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

//package sample;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class Scraper extends Thread {
//
//    public List<String> healthList = new ArrayList<>();
//    public List<String> hotList = new ArrayList<>();
//    public List<String> covidList = new ArrayList<>();
//    public List<String> politicsList = new ArrayList<>();
//    public List<String> businessList = new ArrayList<>();
//    public List<String> worldList = new ArrayList<>();
//    public List<String> othersList = new ArrayList<>();
//    public List<String> techList = new ArrayList<>();
//    public List<String> entertainmentList = new ArrayList<>();
//    public List<String> sportsList = new ArrayList<>();
//
//
//    String[] healthSites = {"https://vnexpress.net/suc-khoe", "https://zingnews.vn/suc-khoe.html"};
//
//    public Scraper() {
//    }
//
//    public void run(String type) throws IOException {
//        if ("health".equals(type)) {
//            List<String> health;
//            for (String site : healthSites) {
//                Document document = null;
//                try {
//                    document = Jsoup.connect(site).get();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                if (site.contains("express")) {
//                    health = document.select("h3 > a[href$=.html]")
//                            .stream().map(p -> p.attr("abs:href"))
//                            .limit(10)
//                            .collect(Collectors.toList());
//                    healthList.addAll(health);
//                } else {
//                    health = document.select("p.article-title > a[href$=.html]")
//                            .stream().map(p -> p.attr("abs:href"))
//                            .limit(10)
//                            .collect(Collectors.toList());
//                    healthList.addAll(health);
//                }
//            }
//        } else if ("covid".equals(type)) {
//            Document document = Jsoup.connect("https://vnexpress.net/tin-tuc-24h").get();
//            hotList = document.select("h3 > a[href$=.html]")
//                    .stream().map(p -> p.attr("abs:href"))
//                    .limit(10)
//                    .collect(Collectors.toList());
//        } else if ("politics".equals(type)) {
//            Document document = Jsoup.connect("https://vnexpress.net/phap-luat").get();
//            politicsList = document.select("h3 > a[href$=.html]")
//                    .stream().map(p -> p.attr("abs:href"))
//                    .limit(10)
//                    .collect(Collectors.toList());
//        } else if ("business".equals(type)) {
//            Document document = Jsoup.connect("https://vnexpress.net/kinh-doanh").get();
//            businessList = document.select("h3 > a[href$=.html]")
//                    .stream().map(p -> p.attr("abs:href"))
//                    .limit(10)
//                    .collect(Collectors.toList());
//        } else if ("others".equals(type)) {
//            Document document = Jsoup.connect("https://vnexpress.net/oto-xe-may").get();
//            othersList = document.select("h3 > a[href$=.html]")
//                    .stream().map(p -> p.attr("abs:href"))
//                    .limit(10)
//                    .collect(Collectors.toList());
//        } else if ("tech".equals(type)) {
//            Document document = Jsoup.connect("https://vnexpress.net/so-hoa").get();
//            techList = document.select("h3 > a[href$=.html]")
//                    .stream().map(p -> p.attr("abs:href"))
//                    .limit(10)
//                    .collect(Collectors.toList());
//        } else if ("entertainment".equals(type)) {
//            Document document = Jsoup.connect("https://vnexpress.net/giai-tri").get();
//            entertainmentList = document.select("h3 > a[href$=.html]")
//                    .stream().map(p -> p.attr("abs:href"))
//                    .limit(10)
//                    .collect(Collectors.toList());
//        } else if ("world".equals(type)) {
//            Document document = Jsoup.connect("https://vnexpress.net/the-gioi").get();
//            worldList = document.select("h3 > a[href$=.html]")
//                    .stream().map(p -> p.attr("abs:href"))
//                    .limit(10)
//                    .collect(Collectors.toList());
//        } else {
//            Document document = Jsoup.connect("https://vnexpress.net/the-thao").get();
//            sportsList = document.select("h3 > a[href$=.html]")
//                    .stream().map(p -> p.attr("abs:href"))
//                    .limit(10)
//                    .collect(Collectors.toList());
//        }
//    }
//
//    public List<String> getHealth() {
//        return healthList;
//    }
//
//    public List<String> getNew() {
//        return hotList;
//    }
//
//    public List<String> getCovid() {
//        return covidList;
//    }
//
//    public List<String> getPolitics()  {
//        return politicsList;
//    }
//
//    public List<String> getBusiness() {
//        return businessList;
//    }
//
//    public List<String> getOthers() {
//        return othersList;
//    }
//
//    public List<String> getTech() {
//        return techList;
//    }
//
//    public List<String> getEntertainment() {
//        return entertainmentList;
//    }
//
//    public List<String> getWorld() {
//        return worldList;
//    }
//
//    public List<String> getSports() {
//
//        return sportsList;
//    }
//}
//
////        Document document = Jsoup.connect("https://thanhnien.vn/the-thao/").get();
////        healthList = document.select("h2 > a[href$=.html]")
////                .stream().map(p -> p.attr("abs:href"))
////                .limit(10)
////                .collect(Collectors.toList());
////        Document document = Jsoup.connect("https://tuoitre.vn/the-thao.htm").get();
////        healthList = document.select("h2 > a[href$=.html]")
////                .stream().map(p -> p.attr("abs:href"))
////                .limit(10)
////                .collect(Collectors.toList());
////        Document document = Jsoup.connect("https://zingnews.vn/suc-khoe.html").get();
////        healthList = document.select("h2 > a[href$=.html]")
////                .stream().map(p -> p.attr("abs:href"))
////                .limit(10)
////                .collect(Collectors.toList());
//
//
////    public News getVENews(String link) throws IOException {
////        News news = new News();
////        Document document = Jsoup.connect(link).get();
////        document.childNodes()
////                .stream()
////                .filter(node -> node instanceof DocumentType)
////                .findFirst()
////                .ifPresent(Node::remove);
////        String title = document.getElementsByClass("title-detail").text();
////        String summary = document.select("p.description").text();
////        String timeline = document.getElementsByClass("date").text();
////        String imgUrl = document.select("img").attr("data-src");
////        news.setTitle(title);
////        news.setPubDate(timeline);
////        news.setLink(link);
////        news.setSummary(summary);
////        if (imgUrl != null) {
////            news.setImage(imgUrl);
////        }
////        return news;
////    }
//
////        for (String link : sectionList) {
////            Document = Jsoup.connect("https://vnexpress.net/sieu-thi-tp-hcm-dong-cua-som-4330708.html").get();
////            String title = document.getElementsByClass("title-detail").text();
////            String summary = document.select("p.description").text();
////            String content = document.select("article.fck_detail > p").text();
////            news.setDescription(summary);
////            news.setImageUrl(imgUrl);
////            news.setTitle(title);
////            news.setPubDate(timeline);
////            news.setContent(content);
////            newsList.add(news);
////        String body = content.text();
////        Element content = document.select("article").first();
////        List<String> imgUrl = document.select("img[src]")
////                              .stream().map(p -> p.attr("data-src"))
////                              .filter(String -> !String.trim().isEmpty())
////                              .collect(Collectors.toList());
//
