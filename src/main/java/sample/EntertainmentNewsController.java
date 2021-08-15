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

public class EntertainmentNewsController implements Initializable {

    @FXML
    private GridPane entertainment;

    private List<Article> entertainmentNewsList = new ArrayList<>();
    private Sites site = new Sites();

    private ArrayList<Article> getSportsArticle() throws IOException {
        Categories categories = new Categories();
        ArrayList<Article> entertainmentNewsList = new ArrayList<>();
        Article article;
        for (String link : categories.getEntertainmentList()) {
            article = site.getVnExpress(link);
            entertainmentNewsList.add(article);
        }
        return entertainmentNewsList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            entertainmentNewsList.addAll(getSportsArticle());
            int column = 0;
            int row = 1;
            for (int i = 0; i < entertainmentNewsList.size(); i++) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/FXML/ArticleCell.fxml"));
                AnchorPane anchorPane = loader.load();

                ArticleCellController articleCellController = loader.getController();
                articleCellController.setArticle(entertainmentNewsList.get(i));

                if (column == 4) {
                    column = 0;
                    row++;
                }

                entertainment.add(anchorPane, column++, row);
                anchorPane.setPadding(new Insets(15));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}