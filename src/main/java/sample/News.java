package sample;

import java.util.List;

public class News {
    private String title;
    private String description;
    private String content;
    private List<String> imageUrl;
    private String pubDate;

    private String link;

    public News() {
    }

    public News(String title, String description, List<String> imageUrl, String pubDate, String link) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.pubDate = pubDate;
        this.link = link;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getImageUrl() {
        return this.imageUrl;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "News{" +
                "title=" + title +
                ", description='" + description + '\'' +
                ", publish date='" + pubDate + '\'' +
                ", description='" + link;
    }
}
