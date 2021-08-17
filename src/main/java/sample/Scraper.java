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

    String[] healthSites = {"https://vnexpress.net/suc-khoe", "https://zingnews.vn/suc-khoe.html", "https://nhandan.vn/tag/chamsocsuckhoe-13170",
            "https://tuoitre.vn/suc-khoe.htm", "https://thanhnien.vn/suc-khoe/"};
    String[] covidSites = {"https://vnexpress.net/goc-nhin/covid-19", "https://zingnews.vn/tieu-diem/covid-19-bung-phat-2021.html?src=home_trending",
            "https://nhandan.vn/tag/Covid19-53", "https://tuoitre.vn/covid-19.html", "https://thanhnien.vn/covid-19/"};
    String[] hotSites = {"https://vnexpress.net/tin-tuc-24h", "https://zingnews.vn/", "https://nhandan.vn/",
            "https://tuoitre.vn/", "https://thanhnien.vn/"};
    String[] politicsSites = {"https://vnexpress.net/phap-luat", "https://zingnews.vn/chinh-tri.html", "https://nhandan.vn/chinhtri",
            "https://tuoitre.vn/bo-chinh-tri.html", "https://thanhnien.vn/thoi-su/chinh-tri/"};
    String[] businessSites = {"https://vnexpress.net/kinh-doanh", "https://zingnews.vn/kinh-doanh-tai-chinh.html", "https://nhandan.vn/tag/kinhdoanh-12135",
            "https://tuoitre.vn/kinh-doanh.htm", "https://thanhnien.vn/tai-chinh-kinh-doanh/"};
    String[] worldSites = {"https://vnexpress.net/the-gioi", "https://zingnews.vn/the-gioi.html", "https://nhandan.vn/thegioi",
            "https://tuoitre.vn/the-gioi.htm", "https://thanhnien.vn/the-gioi/"};
    String[] techSites = {"https://vnexpress.net/so-hoa", "https://zingnews.vn/cong-nghe.html", "https://nhandan.vn/khoahoc-congnghe",
            "https://congnghe.tuoitre.vn/", "https://thanhnien.vn/cong-nghe/"};
    String[] entertainmentSites = {"https://vnexpress.net/giai-tri", "https://zingnews.vn/giai-tri.html", "https://nhandan.vn/giai-tri/",
            "https://tuoitre.vn/giai-tri.htm", "https://thanhnien.vn/giai-tri/"};
    String[] sportsSites = {"https://vnexpress.net/the-thao", "https://zingnews.vn/the-thao.html", "https://nhandan.vn/thethao",
            "https://tuoitre.vn/the-thao.htm", "https://thanhnien.vn/the-thao/"};
    String[] othersSites = {"https://vnexpress.net/oto-xe-may", "https://zingnews.vn/thoi-su.html", "https://nhandan.vn/du-lich",
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
                } else if (site.contains("zingnews")){
                    health = document.select("p.article-title > a[href$=.html]")
                            .stream().map(p -> p.attr("abs:href"))
                            .limit(10)
                            .collect(Collectors.toList());
                    healthList.addAll(health);
                } else if (site.contains("nhandan")) {
                    health = document.select("div.box-title > a[href]")
                            .stream().map(p -> p.attr("abs:href"))
                            .limit(10)
                            .collect(Collectors.toList());
                    healthList.addAll(health);
                } else if (site.contains("tuoitre")) {
                    health = document.select("h3.title-news > a[href$=.htm]")
                            .stream().map(p -> p.attr("abs:href"))
                            .limit(10)
                            .collect(Collectors.toList());
                    healthList.addAll(health);
                } else {
                    health = document.select("h2 > a[href$=.html]")
                            .stream().map(p -> p.attr("abs:href"))
                            .limit(10)
                            .collect(Collectors.toList());
                    healthList.addAll(health);
                }
            }
        return healthList;
    }

    public List<String> getNew() {

        List<String> latest;

        for (String site : hotSites) {
            Document document = null;
            try {
                assert false;
                document = Jsoup.connect(site).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (site.contains("express")) {
                latest = document.select("h3 > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                hotList.addAll(latest);
            } else if (site.contains("zingnews")){
                latest = document.select("p.article-title > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                hotList.addAll(latest);
            } else if (site.contains("nhandan")) {
                latest = document.select("div.box-title > a[href]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                hotList.addAll(latest);
            } else if (site.contains("tuoitre")) {
                latest = document.select("h3.title-news > a[href$=.htm]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                hotList.addAll(latest);
            } else {
                latest = document.select("h2 > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                hotList.addAll(latest);
            }
        }

        return hotList;
    }

    public List<String> getCovid() {

        List<String> covid;

        for (String site : covidSites) {
            Document document = null;
            try {
                assert false;
                document = Jsoup.connect(site).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (site.contains("express")) {
                covid = document.select("h3 > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                covidList.addAll(covid);
            } else if (site.contains("zingnews")){
                covid = document.select("p.article-title > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                covidList.addAll(covid);
            } else if (site.contains("nhandan")) {
                covid = document.select("div.box-title > a[href]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                hotList.addAll(covid);
            } else if (site.contains("tuoitre")) {
                covid = document.select("h3.title-news > a[href$=.htm]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                hotList.addAll(covid);
            } else {
                covid = document.select("h2 > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                hotList.addAll(covid);
            }
        }

        return covidList;
    }

    public List<String> getPolitics() {

        List<String> politic;

        for (String site : politicsSites) {
            Document document = null;
            try {
                assert false;
                document = Jsoup.connect(site).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (site.contains("express")) {
                politic = document.select("h3 > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                politicsList.addAll(politic);
            } else if (site.contains("zingnews")){
                politic = document.select("p.article-title > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                politicsList.addAll(politic);
            } else if (site.contains("nhandan")) {
                politic = document.select("div.box-title > a[href]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                politicsList.addAll(politic);
            } else if (site.contains("tuoitre")) {
                politic = document.select("h3.title-news > a[href$=.htm]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                politicsList.addAll(politic);
            } else {
                politic = document.select("h2 > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                politicsList.addAll(politic);
            }
        }
        return politicsList;
    }

    public List<String> getBusiness() {
        List<String> business;

        for (String site : businessSites) {
            Document document = null;
            try {
                assert false;
                document = Jsoup.connect(site).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (site.contains("express")) {
                business = document.select("h3 > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                businessList.addAll(business);
            } else if (site.contains("zingnews")){
                business = document.select("p.article-title > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                businessList.addAll(business);
            } else if (site.contains("nhandan")) {
                business = document.select("div.box-title > a[href]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                businessList.addAll(business);
            } else if (site.contains("tuoitre")) {
                business = document.select("h3.title-news > a[href$=.htm]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                businessList.addAll(business);
            } else {
                business = document.select("h2 > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                businessList.addAll(business);
            }
        }
        return businessList;
    }

    public List<String> getOthers() {
        List<String> other;

        for (String site : othersSites) {
            Document document = null;
            try {
                assert false;
                document = Jsoup.connect(site).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (site.contains("express")) {
                other = document.select("h3 > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                othersList.addAll(other);
            } else if (site.contains("zingnews")){
                other = document.select("p.article-title > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                othersList.addAll(other);
            } else if (site.contains("nhandan")) {
                other = document.select("div.box-title > a[href]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                othersList.addAll(other);
            } else if (site.contains("tuoitre")) {
                other = document.select("h3.title-news > a[href$=.htm]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                othersList.addAll(other);
            } else {
                other = document.select("h2 > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                othersList.addAll(other);
            }
        }
        return othersList;
    }

    public List<String> getTech() {
        List<String> technology;

        for (String site : techSites) {
            Document document = null;
            try {
                assert false;
                document = Jsoup.connect(site).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (site.contains("express")) {
                technology = document.select("h3 > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                techList.addAll(technology);
            } else if (site.contains("zingnews")){
                technology = document.select("p.article-title > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                techList.addAll(technology);
            } else if (site.contains("nhandan")) {
                technology = document.select("div.box-title > a[href]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                techList.addAll(technology);
            } else if (site.contains("tuoitre")) {
                technology = document.select("h3.title-news > a[href$=.htm]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                techList.addAll(technology);
            } else {
                technology = document.select("h2 > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                techList.addAll(technology);
            }
        }
        return techList;
    }

    public List<String> getEntertainment() {
        List<String> entertainment;

        for (String site : entertainmentSites) {
            Document document = null;
            try {
                assert false;
                document = Jsoup.connect(site).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (site.contains("express")) {
                entertainment = document.select("h3 > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                entertainmentList.addAll(entertainment);
            } else if (site.contains("zingnews")){
                entertainment = document.select("p.article-title > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                entertainmentList.addAll(entertainment);
            } else if (site.contains("nhandan")) {
                entertainment = document.select("div.box-title > a[href]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                entertainmentList.addAll(entertainment);
            } else if (site.contains("tuoitre")) {
                entertainment = document.select("h3.title-news > a[href$=.htm]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                entertainmentList.addAll(entertainment);
            } else {
                entertainment = document.select("h2 > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                entertainmentList.addAll(entertainment);
            }
        }
        return entertainmentList;
    }

    public List<String> getWorld() {
        List<String> world;

        for (String site : worldSites) {
            Document document = null;
            try {
                assert false;
                document = Jsoup.connect(site).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (site.contains("express")) {
                world = document.select("h3 > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                worldList.addAll(world);
            } else if (site.contains("zingnews")){
                world = document.select("p.article-title > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                worldList.addAll(world);
            } else if (site.contains("nhandan")) {
                world = document.select("div.box-title > a[href]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                worldList.addAll(world);
            } else if (site.contains("tuoitre")) {
                world = document.select("h3.title-news > a[href$=.htm]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                worldList.addAll(world);
            } else {
                world = document.select("h2 > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                worldList.addAll(world);
            }
        }
        return worldList;
    }

    public List<String> getSports() {
        List<String> sport;

        for (String site : sportsSites) {
            Document document = null;
            try {
                assert false;
                document = Jsoup.connect(site).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (site.contains("express")) {
                sport = document.select("h3 > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                sportsList.addAll(sport);
            } else if (site.contains("zingnews")){
                sport = document.select("p.article-title > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                sportsList.addAll(sport);
            } else if (site.contains("nhandan")) {
                sport = document.select("div.box-title > a[href]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                sportsList.addAll(sport);
            } else if (site.contains("tuoitre")) {
                sport = document.select("h3.title-news > a[href$=.htm]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                sportsList.addAll(sport);
            } else {
                sport = document.select("h2 > a[href$=.html]")
                        .stream().map(p -> p.attr("abs:href"))
                        .limit(10)
                        .collect(Collectors.toList());
                sportsList.addAll(sport);
            }
        }
        return sportsList;
    }
}
