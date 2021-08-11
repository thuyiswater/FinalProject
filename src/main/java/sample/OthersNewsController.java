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

public class OthersNewsController implements Initializable {
    @FXML
    private GridPane others;

    private List<Article> othersNewsList = new ArrayList<>();
    private Categories categories = new Categories();

    public OthersNewsController() throws IOException {
    }

    public Article getVENews(String link) throws IOException {
        Document document = Jsoup.connect(link).get();
        String title = document.getElementsByClass("title-detail").text();
        String summary = document.select("p.description").text();
        String timeline = document.getElementsByClass("date").text();
        String imgUrl = document.select("img").attr("data-src");
        return new Article(title, summary, imgUrl, timeline, link);
    }


    private ArrayList<Article> getOthersArticle() throws IOException {
        ArrayList<Article> politicsNewsList = new ArrayList<>();
        Article article;
        for (String link : categories.getWorldList()) {
            article = getVENews(link);
            politicsNewsList.add(article);
        }
        return politicsNewsList;
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        try {
            othersNewsList.addAll(getOthersArticle());
            int column = 0;
            int row = 1;
            for (int i = 0; i < othersNewsList.size(); i++) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/FXML/ArticleCell.fxml"));
                AnchorPane anchorPane = loader.load();

                ArticleCellController articleCellController = loader.getController();
                articleCellController.setArticle(othersNewsList.get(i));

                if (column == 2) {
                    column = 0;
                    row++;
                }

                others.add(anchorPane, column++, row);
                others.setMaxHeight(Region.USE_COMPUTED_SIZE);
                others.setMaxWidth(Region.USE_COMPUTED_SIZE);
                others.setMinWidth(1750);
                others.setMinHeight(Region.USE_COMPUTED_SIZE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
