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

public class SportsNewsController implements Initializable {

    @FXML
    private GridPane sports;

    private List<Article> sportsNewsList = new ArrayList<>();

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

    private ArrayList<Article> getSportsArticle() throws IOException {
        Categories categories = new Categories();
        ArrayList<Article> sportsNewsList = new ArrayList<>();
        Article article;
        for (String link : categories.getSportsList()) {
            article = getVENews(link);
            sportsNewsList.add(article);
        }
        return sportsNewsList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            sportsNewsList.addAll(getSportsArticle());
            int column = 0;
            int row = 1;
            for (int i = 0; i < sportsNewsList.size(); i++) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/FXML/ArticleCell.fxml"));
                AnchorPane anchorPane = loader.load();

                ArticleCellController articleCellController = loader.getController();
                articleCellController.setArticle(sportsNewsList.get(i));

                if (column == 2) {
                    column = 0;
                    row++;
                }

                sports.add(anchorPane, column++, row);
                sports.setMaxHeight(Region.USE_COMPUTED_SIZE);
                sports.setMaxWidth(Region.USE_COMPUTED_SIZE);
                sports.setMinWidth(1750);
                sports.setMinHeight(Region.USE_COMPUTED_SIZE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
