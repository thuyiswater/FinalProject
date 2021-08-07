package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

    private List<Article> healthNewsList = new ArrayList<>();

    public Article getVENews(String link) throws IOException {
        Article news = new Article();
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

    private ArrayList<Article> getHealthNews() throws IOException {
        Categories categories = new Categories();
        ArrayList<Article> healthNewsList = new ArrayList<>();
        Article news;
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
                articleCellController.setArticle(healthNewsList.get(i));

                if (column == 2) {
                    column = 0;
                    row++;
                }

                health.add(anchorPane, column++, row);
                health.setMaxHeight(Region.USE_COMPUTED_SIZE);
                health.setMaxWidth(Region.USE_COMPUTED_SIZE);
                health.setMinWidth(1750);
                health.setMinHeight(Region.USE_COMPUTED_SIZE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

