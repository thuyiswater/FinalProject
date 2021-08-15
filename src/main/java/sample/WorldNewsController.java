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

public class WorldNewsController implements Initializable {
    @FXML
    private GridPane world;

    private List<Article> worldNewsList = new ArrayList<>();
    private Categories categories = new Categories();
    private Sites site = new Sites();

    public WorldNewsController() throws IOException {
    }

    private ArrayList<Article> getWorldArticle() throws IOException {
        ArrayList<Article> worldNewsList = new ArrayList<>();
        Article article;
        for (String link : categories.getWorldList()) {
            article = site.getVnExpress(link);
            worldNewsList.add(article);
        }
        return worldNewsList;
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        try {
            worldNewsList.addAll(getWorldArticle());
            int column = 0;
            int row = 1;
            for (int i = 0; i < worldNewsList.size(); i++) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/FXML/ArticleCell.fxml"));
                AnchorPane anchorPane = loader.load();

                ArticleCellController articleCellController = loader.getController();
                articleCellController.setArticle(worldNewsList.get(i));

                if (column == 4) {
                    column = 0;
                    row++;
                }

                world.add(anchorPane, column++, row);
                anchorPane.setPadding(new Insets(15));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

