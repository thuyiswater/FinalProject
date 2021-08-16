package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BusinessNewsController implements Initializable {
    @FXML
    private GridPane business;

    private final List<Article> businessNewsList = new ArrayList<>();
    Categories categories = new Categories();
    Sites site = new Sites();

    public BusinessNewsController() throws IOException {
    }

    private ArrayList<Article> getBusinessArticle() throws IOException {
        ArrayList<Article> businessNewsList = new ArrayList<>();
        Article article;
        for (String link : categories.getBusinessList()) {
            article = site.getVnExpress(link);
            businessNewsList.add(article);
        }
        return businessNewsList;
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        try {
            businessNewsList.addAll(getBusinessArticle());
            int column = 0;
            int row = 1;
            for (int i = 0; i < businessNewsList.size(); i++) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/FXML/ArticleCell.fxml"));
                AnchorPane anchorPane = loader.load();

                ArticleCellController articleCellController = loader.getController();
                articleCellController.setArticle(businessNewsList.get(i));

                if (column == 4) {
                    column = 0;
                    row++;
                }

                business.add(anchorPane, column++, row);
                anchorPane.setPadding(new Insets(15));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
