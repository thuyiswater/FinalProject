package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class NewNewsController implements Initializable {

    @FXML
    private GridPane hot;

    private List<Article> hotNewsList = new ArrayList<>();
    private Sites site = new Sites();

    private ArrayList<Article> getNewArticle() throws IOException {
        Categories categories = new Categories();
        ArrayList<Article> hotNewsList = new ArrayList<>();
        Article article;
        for (String link : categories.getNewList()) {
            article = site.getVnExpress(link);
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

                if (column == 4) {
                    column = 0;
                    row++;
                }

                hot.add(anchorPane, column++, row);
                anchorPane.setPadding(new Insets(15));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
