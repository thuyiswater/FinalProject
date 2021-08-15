package sample;

import javafx.scene.Node;

public class Article {
    private String title;
    private String summary;
    private String pubDate;
    private String link;
    private String image;

    public Article(String title, String summary, String image, String pubDate, String link) {
        this.title = title;
        this.summary = summary;
        this.image = image;
        this.pubDate = pubDate;
        this.link = link;
    }

    public Article() {
        setTitle(title);
        setSummary(summary);
        setPubDate(pubDate);
        setImage(image);
        setLink(link);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getSummary() {
        return summary;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "News{" +
                "title=" + title +
                ", summary='" + summary + '\'' +
                ", publish date='" + pubDate + '\'' +
                ", link='" + link;
    }
}
