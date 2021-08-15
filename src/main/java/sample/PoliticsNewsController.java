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

public class PoliticsNewsController implements Initializable {

    @FXML
    private GridPane politics;

    private List<Article> politicsNewsList = new ArrayList<>();
    private Categories categories = new Categories();
    private Sites site = new Sites();

    public PoliticsNewsController() throws IOException {
    }

    private ArrayList<Article> getPoliticsArticle() throws IOException {
        ArrayList<Article> politicsNewsList = new ArrayList<>();
        Article article;
        for (String link : categories.getPoliticsList()) {
            article = site.getVnExpress(link);
            politicsNewsList.add(article);
        }
        return politicsNewsList;
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        try {
            politicsNewsList.addAll(getPoliticsArticle());
            int column = 0;
            int row = 1;
            for (int i = 0; i < politicsNewsList.size(); i++) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/FXML/ArticleCell.fxml"));
                AnchorPane anchorPane = loader.load();

                ArticleCellController articleCellController = loader.getController();
                articleCellController.setArticle(politicsNewsList.get(i));

                if (column == 4) {
                    column = 0;
                    row++;
                }

                politics.add(anchorPane, column++, row);
                anchorPane.setPadding(new Insets(15));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

