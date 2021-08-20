package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Scraper {

    public Scraper() {
    }

    public enum Topic {
        HEALTH,
        COVID,
        LATEST,
        POLITICS,
        BUSINESS,
        WORLD,
        TECH,
        ENTERTAINMENT,
        SPORTS,
        OTHERS
    }

    private static final Map<Topic, List<String>> TOPIC_TO_URLS = Map.of(
            Topic.HEALTH, List.of(
                    "https://vnexpress.net/suc-khoe",
                    "https://zingnews.vn/suc-khoe.html",
                    "https://nhandan.vn/y-te",
                    "https://tuoitre.vn/suc-khoe.htm",
                    "https://thanhnien.vn/suc-khoe/"),
            Topic.COVID, List.of(
                    "https://vnexpress.net/goc-nhin/covid-19",
                    "https://zingnews.vn/tieu-diem/covid-19-bung-phat-2021.html?src=home_trending",
                    "https://nhandan.vn/tag/Covid19-53",
                    "https://tuoitre.vn/covid-19.html",
                    "https://thanhnien.vn/covid-19/"),
            Topic.LATEST, List.of(
                    "https://vnexpress.net/tin-tuc-24h",
                    "https://zingnews.vn/",
                    "https://nhandan.vn/",
                    "https://tuoitre.vn/",
                    "https://thanhnien.vn/"),
            Topic.POLITICS, List.of(
                    "https://vnexpress.net/phap-luat",
                    "https://zingnews.vn/chinh-tri.html",
                    "https://nhandan.vn/chinhtri",
                    "https://tuoitre.vn/bo-chinh-tri.html",
                    "https://thanhnien.vn/thoi-su/chinh-tri/"),
            Topic.BUSINESS, List.of(
                    "https://vnexpress.net/kinh-doanh",
                    "https://zingnews.vn/kinh-doanh-tai-chinh.htmlnha",
                    "https://nhandan.vn/kinhte",
                    "https://tuoitre.vn/kinh-doanh.htm",
                    "https://thanhnien.vn/tai-chinh-kinh-doanh/"),
            Topic.WORLD, List.of(
                    "https://vnexpress.net/the-gioi",
                    "https://zingnews.vn/the-gioi.html",
                    "https://nhandan.vn/thegioi",
                    "https://tuoitre.vn/the-gioi.htm",
                    "https://thanhnien.vn/the-gioi/"),
            Topic.TECH, List.of(
                    "https://vnexpress.net/so-hoa",
                    "https://zingnews.vn/cong-nghe.html",
                    "https://nhandan.vn/khoahoc-congnghe",
                    "https://congnghe.tuoitre.vn/",
                    "https://thanhnien.vn/cong-nghe/"),
            Topic.ENTERTAINMENT, List.of(
                    "https://vnexpress.net/giai-tri",
                    "https://zingnews.vn/giai-tri.html",
                    "https://nhandan.vn/giai-tri/",
                    "https://tuoitre.vn/giai-tri.htm",
                    "https://thanhnien.vn/giai-tri/"),
            Topic.SPORTS, List.of(
                    "https://vnexpress.net/the-thao",
                    "https://zingnews.vn/the-thao.html",
                    "https://nhandan.vn/thethao",
                    "https://tuoitre.vn/the-thao.htm",
                    "https://thanhnien.vn/the-thao/"),
            Topic.OTHERS, List.of(
                    "https://vnexpress.net/oto-xe-may",
                    "https://zingnews.vn/thoi-su.html",
                    "https://nhandan.vn/du-lich",
                    "https://dulich.tuoitre.vn/",
                    "https://thanhnien.vn/du-lich/"));

    private static final Map<String, String> SITE_TO_SELECTOR = Map.of(
            "vnexpress", "h3 > a[href$=.html]",
            "zingnews", "p.article-title > a[href$=.html]",
            "nhandan", "div.box-title > a[href]",
            "tuoitre", "h3.title-news > a[href$=.htm]",
            "thanhnien", "h2 > a[href$=.html]"
    );

    private static Document getDocument(String site) {
        try {
            return Jsoup.connect(site).get();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static List<String> extractUrls(Document document, String site) {
        for (Map.Entry<String, String> siteAndSelector : Scraper.SITE_TO_SELECTOR.entrySet()) {
            if (site.contains(siteAndSelector.getKey())) {
                return document.select(siteAndSelector.getValue())
                        .stream()
                        .map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
            }
        }
        throw new AssertionError();
    }

    public CompletableFuture<List<String>> getUrls(Topic topic) {
        return CompletableFuture.supplyAsync(() -> {
            List<String> urls = new ArrayList<>();
            for (String site : TOPIC_TO_URLS.get(topic)) {
                Document doc = getDocument(site);
                urls.addAll(extractUrls(doc, site));
            }
            return urls;
        });
    }
}

//    ExecutorService service = Executors.newCachedThreadPool();
//    Future<List<String>> healthTask = service.submit(this::getHealth);
//    Future<List<String>> covidTask = service.submit(this::getCovid);
//    Future<List<String>> hotTask = service.submit(this::getNew);
//    Future<List<String>> politicsTask = service.submit(this::getPolitics);
//    Future<List<String>> businessTask = service.submit(this::getBusiness);
//    Future<List<String>> worldTask = service.submit(this::getWorld);
//    Future<List<String>> techTask = service.submit(this::getTech);
//    Future<List<String>> entertainmentTask = service.submit(this::getEntertainment);
//    Future<List<String>> sportsTask = service.submit(this::getSports);
//    Future<List<String>> othersTask = service.submit(this::getOthers);
//    private final List<String> healthList = new ArrayList<>();
//    private final List<String> covidList = new ArrayList<>();
//    private final List<String> hotList = new ArrayList<>();
//    private final List<String> politicsList = new ArrayList<>();
//    private final List<String> businessList = new ArrayList<>();
//    private final List<String> worldList = new ArrayList<>();
//    private final List<String> othersList = new ArrayList<>();
//    private final List<String> techList = new ArrayList<>();
//    private final List<String> entertainmentList = new ArrayList<>();
//    private final List<String> sportsList = new ArrayList<>();
//    public List<String> getHealth() {
//        List<String> health = new ArrayList<>();
//            for (String site : healthSites) {
//                Document document = null;
//                try {
//                    assert false;
//                    document = Jsoup.connect(site).get();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                if (site.contains("vnexpress")) {
//                    health.addAll(document.select("h3 > a[href$=.html]")
//                            .stream().map(p -> p.attr("abs:href"))
//                            .limit(10)
//                            .collect(Collectors.toList()));
//                } else if (site.contains("zingnews")) {
//                    health.addAll(document.select("p.article-title > a[href$=.html]")
//                            .stream().map(p -> p.attr("abs:href"))
//                            .limit(10)
//                            .collect(Collectors.toList()));
//                } else if (site.contains("nhandan")) {
//                    health.addAll(document.select("div.box-title > a[href]")
//                            .stream().map(p -> p.attr("abs:href"))
//                            .limit(10)
//                            .collect(Collectors.toList()));
//                } else if (site.contains("tuoitre")) {
//                    health.addAll(document.select("h3.title-news > a[href$=.htm]")
//                            .stream().map(p -> p.attr("abs:href"))
//                            .limit(10)
//                            .collect(Collectors.toList()));
//                } else {
//                    health.addAll(document.select("h2 > a[href$=.html]")
//                            .stream().map(p -> p.attr("abs:href"))
//                            .limit(10)
//                            .collect(Collectors.toList()));
//                }
//            }
//        return health;
//    }
//    public List<String> getNew() {
//        List<String> latest = new ArrayList<>();
//        for (String site : hotSites) {
//            Document document = null;
//            try {
//                assert false;
//                document = Jsoup.connect(site).get();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (site.contains("express")) {
//                latest.addAll(document.select("h3 > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList()));
//            } else if (site.contains("zingnews")){
//                latest.addAll(document.select("p.article-title > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList()));
//            } else if (site.contains("nhandan")) {
//                latest.addAll(document.select("div.box-title > a[href]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList()));
//            } else if (site.contains("tuoitre")) {
//                latest = document.select("h3.title-news > a[href$=.htm]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//            } else {
//                latest.addAll(document.select("h2 > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList()));
//            }
//        }
//        return latest;
//    }
//
//    public List<String> getCovid() {
//        List<String> covid;
//        for (String site : covidSites) {
//            Document document = null;
//            try {
//                assert false;
//                document = Jsoup.connect(site).get();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (site.contains("express")) {
//                covid = document.select("h3 > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                covidList.addAll(covid);
//            } else if (site.contains("zingnews")){
//                covid = document.select("p.article-title > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                covidList.addAll(covid);
//            } else if (site.contains("nhandan")) {
//                covid = document.select("div.box-title > a[href]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                covidList.addAll(covid);
//            } else if (site.contains("tuoitre")) {
//                covid = document.select("h3.title-news > a[href$=.htm]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                covidList.addAll(covid);
//            } else {
//                covid = document.select("h2 > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                covidList.addAll(covid);
//            }
//        }
//        return covidList;
//    }
//
//    public List<String> getPolitics() {
//        List<String> politic;
//        for (String site : politicsSites) {
//            Document document = null;
//            try {
//                assert false;
//                document = Jsoup.connect(site).get();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (site.contains("express")) {
//                politic = document.select("h3 > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                politicsList.addAll(politic);
//            } else if (site.contains("zingnews")){
//                politic = document.select("p.article-title > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                politicsList.addAll(politic);
//            } else if (site.contains("nhandan")) {
//                politic = document.select("div.box-title > a[href]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                politicsList.addAll(politic);
//            } else if (site.contains("tuoitre")) {
//                politic = document.select("h3.title-news > a[href$=.htm]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                politicsList.addAll(politic);
//            } else {
//                politic = document.select("h2 > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                politicsList.addAll(politic);
//            }
//        }
//        return politicsList;
//    }
//
//    public List<String> getBusiness() {
//        List<String> business;
//        for (String site : businessSites) {
//            Document document = null;
//            try {
//                assert false;
//                document = Jsoup.connect(site).get();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (site.contains("express")) {
//                business = document.select("h3 > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                businessList.addAll(business);
//            } else if (site.contains("zingnews")){
//                business = document.select("p.article-title > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                businessList.addAll(business);
//            } else if (site.contains("nhandan")) {
//                business = document.select("div.box-title > a[href]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                businessList.addAll(business);
//            } else if (site.contains("tuoitre")) {
//                business = document.select("h3.title-news > a[href$=.htm]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                businessList.addAll(business);
//            } else {
//                business = document.select("h2 > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                businessList.addAll(business);
//            }
//        }
//        return businessList;
//    }
//
//    public List<String> getOthers() {
//        List<String> other;
//        for (String site : othersSites) {
//            Document document = null;
//            try {
//                assert false;
//                document = Jsoup.connect(site).get();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (site.contains("express")) {
//                other = document.select("h3 > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                othersList.addAll(other);
//            } else if (site.contains("zingnews")){
//                other = document.select("p.article-title > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                othersList.addAll(other);
//            } else if (site.contains("nhandan")) {
//                other = document.select("div.box-title > a[href]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                othersList.addAll(other);
//            } else if (site.contains("tuoitre")) {
//                other = document.select("h3.title-news > a[href$=.htm]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                othersList.addAll(other);
//            } else {
//                other = document.select("h2 > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                othersList.addAll(other);
//            }
//        }
//        return othersList;
//    }
//
//    public List<String> getTech() {
//        List<String> technology;
//        for (String site : techSites) {
//            Document document = null;
//            try {
//                assert false;
//                document = Jsoup.connect(site).get();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (site.contains("express")) {
//                technology = document.select("h3 > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                techList.addAll(technology);
//            } else if (site.contains("zingnews")){
//                technology = document.select("p.article-title > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                techList.addAll(technology);
//            } else if (site.contains("nhandan")) {
//                technology = document.select("div.box-title > a[href]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                techList.addAll(technology);
//            } else if (site.contains("tuoitre")) {
//                technology = document.select("h3.title-news > a[href$=.htm]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                techList.addAll(technology);
//            } else {
//                technology = document.select("h2 > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                techList.addAll(technology);
//            }
//        }
//        return techList;
//    }
//
//    public List<String> getEntertainment() {
//        List<String> entertainment;
//        for (String site : entertainmentSites) {
//            Document document = null;
//            try {
//                assert false;
//                document = Jsoup.connect(site).get();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (site.contains("express")) {
//                entertainment = document.select("h3 > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                entertainmentList.addAll(entertainment);
//            } else if (site.contains("zingnews")){
//                entertainment = document.select("p.article-title > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                entertainmentList.addAll(entertainment);
//            } else if (site.contains("nhandan")) {
//                entertainment = document.select("div.box-title > a[href]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                entertainmentList.addAll(entertainment);
//            } else if (site.contains("tuoitre")) {
//                entertainment = document.select("h3.title-news > a[href$=.htm]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                entertainmentList.addAll(entertainment);
//            } else {
//                entertainment = document.select("h2 > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                entertainmentList.addAll(entertainment);
//            }
//        }
//        return entertainmentList;
//    }
//
//    public List<String> getWorld() {
//        List<String> world;
//        for (String site : worldSites) {
//            Document document = null;
//            try {
//                assert false;
//                document = Jsoup.connect(site).get();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (site.contains("express")) {
//                world = document.select("h3 > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                worldList.addAll(world);
//            } else if (site.contains("zingnews")){
//                world = document.select("p.article-title > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                worldList.addAll(world);
//            } else if (site.contains("nhandan")) {
//                world = document.select("div.box-title > a[href]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                worldList.addAll(world);
//            } else if (site.contains("tuoitre")) {
//                world = document.select("h3.title-news > a[href$=.htm]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                worldList.addAll(world);
//            } else {
//                world = document.select("h2 > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                worldList.addAll(world);
//            }
//        }
//        return worldList;
//    }
//
//    public List<String> getSports() {
//        List<String> sport;
//        for (String site : sportsSites) {
//            Document document = null;
//            try {
//                assert false;
//                document = Jsoup.connect(site).get();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (site.contains("express")) {
//                sport = document.select("h3 > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                sportsList.addAll(sport);
//            } else if (site.contains("zingnews")){
//                sport = document.select("p.article-title > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                sportsList.addAll(sport);
//            } else if (site.contains("nhandan")) {
//                sport = document.select("div.box-title > a[href]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                sportsList.addAll(sport);
//            } else if (site.contains("tuoitre")) {
//                sport = document.select("h3.title-news > a[href$=.htm]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                sportsList.addAll(sport);
//            } else {
//                sport = document.select("h2 > a[href$=.html]")
//                        .stream().map(p -> p.attr("abs:href"))
//                        .limit(10)
//                        .collect(Collectors.toList());
//                sportsList.addAll(sport);
//            }
//        }
//        return sportsList;
//    }
