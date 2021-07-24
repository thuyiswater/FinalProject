package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class NewsListController implements Initializable {
    @FXML
    ListView<News> newsListView;

    List<News> newsList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RSSFeed rssFeed = new RSSFeed();
        try {
            newsList = rssFeed.parserRSS("https://vnexpress.net/rss/tin-moi-nhat.rss");
            newsListView.getItems().addAll(newsList);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
