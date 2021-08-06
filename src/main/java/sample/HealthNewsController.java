package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HealthNewsController implements Initializable {

    @FXML
    private GridPane health;

    @FXML
    private ScrollPane scroll;

    Categories categories = new Categories();

    private List<News> healthNewsList = new ArrayList<>();

    public News getVENews(String link) throws IOException {
        News news = new News();
        Document document = Jsoup.connect(link).get();
        document.childNodes()
                .stream()
                .filter(node -> node instanceof DocumentType)
                .findFirst()
                .ifPresent(Node::remove);
        String title = document.getElementsByClass("title-detail").text();
        String summary = document.select("p.description").text();
        String timeline = document.getElementsByClass("date").text();
        String imgUrl = document.select("img").attr("data-src");
        news.setTitle(title);
        news.setPubDate(timeline);
        news.setLink(link);
        news.setSummary(summary);
        if (imgUrl != null) {
            news.setImage(imgUrl);
        }
        return news;
    }

    private List<News> getHealthNews() throws IOException {
        List<News> healthNewsList = new ArrayList<>();
        News news;
        Scraper scraper = new Scraper();
        for (String link : categories.getHealthList()) {
            news = getVENews(link);
            healthNewsList.add(news);
        }
        return healthNewsList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            healthNewsList.addAll(getHealthNews());
            int column = 0;
            int row = 1;
            for (int i = 0; i < healthNewsList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/FXML/ArticleCell.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ArticleCellController articleCellController = fxmlLoader.getController();
                articleCellController.setNews(healthNewsList.get(i));

                if (column == 3) {
                    column = 0;
                    row++;
                }

                health.add(anchorPane, column++, row);
                health.setMaxHeight(Region.USE_COMPUTED_SIZE);
                health.setMaxWidth(Region.USE_COMPUTED_SIZE);
                health.setMinWidth(1750);
                health.setMinHeight(Region.USE_COMPUTED_SIZE);
                GridPane.setMargin(health, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

