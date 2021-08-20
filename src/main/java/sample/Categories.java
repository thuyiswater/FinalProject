package sample;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Categories {
    private final List<String> latestList;
    private final List<String> covidList;
    private final List<String> politicsList;
    private final List<String> businessList;
    private final List<String> technologyList;
    private final List<String> healthList;
    private final List<String> sportsList;
    private final List<String> entertainmentList;
    private final List<String> worldList;
    private final List<String> othersList;

    Scraper scraper =  new Scraper();

    public Categories() throws IOException, ExecutionException, InterruptedException {
        latestList = scraper.getUrls(Scraper.Topic.LATEST).get();
        healthList = scraper.getUrls(Scraper.Topic.HEALTH).get();
        covidList = scraper.getUrls(Scraper.Topic.COVID).get();
        politicsList = scraper.getUrls(Scraper.Topic.POLITICS).get();
        businessList = scraper.getUrls(Scraper.Topic.BUSINESS).get();
        technologyList = scraper.getUrls(Scraper.Topic.TECH).get();
        sportsList = scraper.getUrls(Scraper.Topic.SPORTS).get();
        entertainmentList = scraper.getUrls(Scraper.Topic.ENTERTAINMENT).get();
        worldList =  scraper.getUrls(Scraper.Topic.WORLD).get();
        othersList = scraper.getUrls(Scraper.Topic.OTHERS).get();
    }

    public List<String> getLatestList() {
        return latestList;
    }

    public List<String> getCovidList() {
        return covidList;
    }

    public List<String> getPoliticsList() {
        return politicsList;
    }

    public List<String> getBusinessList() {
        return businessList;
    }

    public List<String> getTechnologyList() {
        return technologyList;
    }

    public List<String> getHealthList() {
        return healthList;
    }

    public List<String> getSportsList() {
        return sportsList;
    }

    public List<String> getEntertainmentList() {
        return entertainmentList;
    }

    public List<String> getWorldList() {
        return worldList;
    }

    public List<String> getOthersList() {
        return othersList;
    }
}