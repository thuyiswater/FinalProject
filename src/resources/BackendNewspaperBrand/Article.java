package com.company;

public class Article {
    //Attributes
    private String title;
    private String link;
    private String image;
    private String summary;
    private String pubDate;

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    //Getter
    public String getTitle() {
        return this.title;
    }

    public String getLink() {
        return this.link;
    }

    public String getImage() {
        return this.image;
    }

    public String getSummary() {
        return this.summary;
    }



    //Setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }


    //Constructor
    //Empty
    public Article(){

    }
    //Parameterized
    public Article(String title, String link, String image, String summary, String category, String brand) {
        this.title = title;
        this.link = link;
        this.image = image;
        this.summary = summary;
    }

}
