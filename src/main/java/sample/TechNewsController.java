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

public class TechNewsController implements Initializable {
    @FXML
    private GridPane tech;

    private List<Article> techNewsList = new ArrayList<>();
    private Categories categories = new Categories();
    private Sites site = new Sites();

    public TechNewsController() throws IOException {
    }

    private ArrayList<Article> getTechArticle() throws IOException {
        ArrayList<Article> techNewsList = new ArrayList<>();
        Article article;
        for (String link : categories.getTechnologyList()) {
            article = site.getVnExpress(link);
            techNewsList.add(article);
        }
        return techNewsList;
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        try {
            techNewsList.addAll(getTechArticle());
            int column = 0;
            int row = 1;
            for (int i = 0; i < techNewsList.size(); i++) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/FXML/ArticleCell.fxml"));
                AnchorPane anchorPane = loader.load();

                ArticleCellController articleCellController = loader.getController();
                articleCellController.setArticle(techNewsList.get(i));

                if (column == 4) {
                    column = 0;
                    row++;
                }

                tech.add(anchorPane, column++, row);
                anchorPane.setPadding(new Insets(15));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
