package sample;

public class Article {
    private String title;
    private String description;
    private String pubDate;
    private String link;

    private String guid;

    public Article(News news) {
        this.title = news.getTitle();
        this.description = news.getSummary();
        this.pubDate = news.getPubDate();
        this.link = news.getLink();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getLink() {
        return link;
    }

    public String getGuid() {
        return guid;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title=" + title +
                ", description='" + description + '\'' +
                ", publish date='" + pubDate + '\'' +
                ", description='" + link + '\'' +
                ", guide='" + guid;
    }
}
