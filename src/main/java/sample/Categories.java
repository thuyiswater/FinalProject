package sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Categories {
    private final List<String> newList;
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

    public Categories() throws IOException {
        newList = scraper.getNew();
        covidList = scraper.getCovid();
        politicsList = scraper.getPolitics();
        businessList = scraper.getBusiness();
        technologyList = scraper.getTech();
        healthList = scraper.getHealth();
        sportsList = scraper.getSports();
        entertainmentList = scraper.getEntertainment();
        worldList = scraper.getWorld();
        othersList = scraper.getOthers();
    }

    public List<String> getNewList() {
        return newList;
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