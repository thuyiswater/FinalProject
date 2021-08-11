package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class NewNewsController implements Initializable {

    @FXML
    private GridPane hot;

    private List<Article> hotNewsList = new ArrayList<>();

    public Article getVENews(String link) throws IOException {
        Article article = new Article();
        Document document = Jsoup.connect(link).get();
        String title = document.getElementsByClass("title-detail").text();
        String summary = document.select("p.description").text();
        String timeline = document.getElementsByClass("date").text();
        String imgUrl = document.select("img").attr("data-src");
        article.setTitle(title);
        article.setPubDate(timeline);
        article.setLink(link);
        article.setSummary(summary);
        if (imgUrl != null) {
            article.setImage(imgUrl);
        }
        return article;
    }

    private ArrayList<Article> getNewArticle() throws IOException {
        Categories categories = new Categories();
        ArrayList<Article> hotNewsList = new ArrayList<>();
        Article article;
        for (String link : categories.getNewList()) {
            article = getVENews(link);
            hotNewsList.add(article);
        }
        return hotNewsList;
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        try {
            hotNewsList.addAll(getNewArticle());
            int column = 0;
            int row = 1;
            for (int i = 0; i < hotNewsList.size(); i++) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/FXML/ArticleCell.fxml"));
                AnchorPane anchorPane = loader.load();

                ArticleCellController articleCellController = loader.getController();
                articleCellController.setArticle(hotNewsList.get(i));

                if (column == 2) {
                    column = 0;
                    row++;
                }

                hot.add(anchorPane, column++, row);
                hot.setMaxHeight(Region.USE_COMPUTED_SIZE);
                hot.setMaxWidth(Region.USE_COMPUTED_SIZE);
                hot.setMinWidth(1750);
                hot.setMinHeight(Region.USE_COMPUTED_SIZE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
