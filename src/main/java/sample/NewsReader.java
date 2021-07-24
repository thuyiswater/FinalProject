package sample;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class NewsReader {
    private News news;

    public NewsReader(News news) {
        this.news = news;
    }

    public void getNews() throws ParserConfigurationException, IOException, SAXException {
        RSSFeed rssFeed = new RSSFeed();
        rssFeed.parserRSS("https://vnexpress.net/rss/tin-moi-nhat.rss");
    }
}
