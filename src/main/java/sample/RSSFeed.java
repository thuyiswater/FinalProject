package sample;

import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class RSSFeed {

    public RSSFeed() {
    }

    public String getRSSFeed(String url) throws InterruptedException, IOException {
        HttpClient site = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = site.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public List<News> parserRSS(String url) throws ParserConfigurationException, IOException, SAXException {
        List<News> newsList = new ArrayList<News>();
        News news = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(url);
        doc.getDocumentElement().normalize();
        NodeList list = doc.getElementsByTagName("item");
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                news = new News();
                news.setTitle(element.getElementsByTagName("title").item(0).getTextContent());
                String common = element.getElementsByTagName("description").item(0).getTextContent();
                org.jsoup.nodes.Document document = Jsoup.parse(common);
                org.jsoup.nodes.Element sourceImage = document.select("img").first();
                org.jsoup.nodes.Element description = document.select("br").first();
                String imageUrl = null;
                if (sourceImage != null) {
                    imageUrl = sourceImage.attr("src");
                } else {
                    continue;
                }
                String sourceDescription = description.text();
                news.setDescription(sourceDescription);
                news.setImageUrl(imageUrl);
                news.setPubDate(element.getElementsByTagName("pubDate").item(0).getTextContent());
                news.setLink(element.getElementsByTagName("link").item(0).getTextContent());
                newsList.add(news);
            }
        }
        return newsList;
    }

}
