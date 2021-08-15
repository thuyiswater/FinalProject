package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SportsNewsController implements Initializable {

    @FXML
    private GridPane sports;

    private List<Article> sportsNewsList = new ArrayList<>();
    private Sites site = new Sites();

    private ArrayList<Article> getSportsArticle() throws IOException {
        Categories categories = new Categories();
        ArrayList<Article> sportsNewsList = new ArrayList<>();
        Article article;
        for (String link : categories.getSportsList()) {
            article = site.getVnExpress(link);
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

                if (column == 4) {
                    column = 0;
                    row++;
                }

                sports.add(anchorPane, column++, row);
                anchorPane.setPadding(new Insets(15));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

