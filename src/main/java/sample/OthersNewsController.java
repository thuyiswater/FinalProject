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

public class OthersNewsController implements Initializable {
    @FXML
    private GridPane others;

    private List<Article> othersNewsList = new ArrayList<>();
    private Categories categories = new Categories();
    private Sites site = new Sites();

    public OthersNewsController() throws IOException {
    }

    private ArrayList<Article> getOthersArticle() throws IOException {
        ArrayList<Article> othersNewsList = new ArrayList<>();
        Article article;
        for (String link : categories.getOthersList()) {
            article = site.getVnExpress(link);
            othersNewsList.add(article);
        }
        return othersNewsList;
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

                if (column == 4) {
                    column = 0;
                    row++;
                }

                others.add(anchorPane, column++, row);
                anchorPane.setPadding(new Insets(15));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
