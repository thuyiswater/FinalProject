package sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Categories {
    private List<String> newList = new ArrayList<>();
    private List<String> covidList = new ArrayList<>();
    private List<String> politicsList = new ArrayList<>();
    private List<String> businessList = new ArrayList<>();
    private List<String> technologyList = new ArrayList<>();
    private List<String> healthList = new ArrayList<>();
    private List<String> sportsList = new ArrayList<>();
    private List<String> entertainmentList = new ArrayList<>();
    private List<String> worldList = new ArrayList<>();
    private List<String> othersList = new ArrayList<>();

    Scraper scraper = new Scraper();

    public Categories() throws IOException {
        setHealthList(scraper.getHealth());
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

    public void setNewList(List<String> newList) {
        this.newList = newList;
    }

    public void setCovidList(List<String> covidList) {
        this.covidList = covidList;
    }

    public void setPoliticsList(List<String> politicsList) {
        this.politicsList = politicsList;
    }

    public void setBusinessList(List<String> businessList) {
        this.businessList = businessList;
    }

    public void setTechnologyList(List<String> technologyList) {
        this.technologyList = technologyList;
    }

    public void setHealthList(List<String> healthList) {
        this.healthList = healthList;
    }

    public void setSportsList(List<String> sportsList) {
        this.sportsList = sportsList;
    }

    public void setEntertainmentList(List<String> entertainmentList) {
        this.entertainmentList = entertainmentList;
    }

    public void setWorldList(List<String> worldList) {
        this.worldList = worldList;
    }

    public void setOthersList(List<String> othersList) {
        this.othersList = othersList;
    }
}
