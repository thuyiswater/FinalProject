package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Pagination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HealthNewsController implements Initializable {

    @FXML
    private GridPane health;

    @FXML
    private Pagination page;

    private List<Article> healthNewsList = new ArrayList<>();
    private Categories categories = new Categories();
    private Sites site = new Sites();
    private static final int ARTICLES_PER_PAGE = 10;
    private static final int MAX_COLS = 4;


    public HealthNewsController() throws IOException {
    }


    private ArrayList<Article> getHealthArticle() throws IOException {
        ArrayList<Article> healthNewsList = new ArrayList<>();
        Article article;
        for (String link : categories.getHealthList()) {
            article = site.getVnExpress(link);
            healthNewsList.add(article);
        }
        return healthNewsList;
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        try {
            healthNewsList.addAll(getHealthArticle());
            int column = 0;
            int row = 1;
            for (int i = 0; i < healthNewsList.size(); i++) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/FXML/ArticleCell.fxml"));
                AnchorPane anchorPane = loader.load();

                ArticleCellController articleCellController = loader.getController();
                articleCellController.setArticle(healthNewsList.get(i));

                if (column == 4) {
                    column = 0;
                    row++;
                }

                health.add(anchorPane, column++, row);
                anchorPane.setPadding(new Insets(15));
//                List<Article> articles = new ArrayList<>();
//                articles.addAll((healthNewsList));
//                var pagination = new Pagination();
//                pagination.setPageFactory(page -> {
//                    int first = page * 10;
//                    var pageArticles = articles.subList(first, first + ARTICLES_PER_PAGE);
//                    var pane = new GridPane();
//                    pane.setHgap(5);
//                    pane.setVgap(5);
//                    for (int j = 0; j < pageArticles.size(); j++) {
//                        pane.add(pageArticles.get(j), j % MAX_COLS, j / MAX_COLS);
//                    }
//                    return pane;
//                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

