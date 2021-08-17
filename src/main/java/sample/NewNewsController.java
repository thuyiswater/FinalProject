package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewNewsController {

    @FXML
    private FlowPane hot;

    private final List<Article> hotNewsList = new ArrayList<>();
    Sites site = new Sites();

    private static final int ARTICLES_PER_PAGE = 10;
    private static final int MAX_COLS = 4;

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
    public void initialize() throws IOException {
        hotNewsList.addAll(getNewArticle());
        List<Node> articles = new ArrayList<>();

        for (int i = 0; i < hotNewsList.size(); i++) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXML/ArticleCell.fxml"));
            AnchorPane anchorPane = loader.load();
            articles.add(anchorPane);

            ArticleCellController articleCellController = loader.getController();
            articleCellController.setArticle(hotNewsList.get(i));
        }
        int pages = articles.size() / 10 + (articles.size() % 10 == 0 ? 0 : 1);
        Pagination pagination = new Pagination(pages);
        pagination.setPageFactory(page -> {
            int first = page * 10;
            List<Node> pageArticles = articles.subList(first, first + ARTICLES_PER_PAGE);
            GridPane pane = new GridPane();
            pane.setHgap(85);
            pane.setVgap(5);
            for (int i = 0; i < pageArticles.size(); i++) {
                pane.add(pageArticles.get(i), i % MAX_COLS, i / MAX_COLS);
            }
            pane.getStylesheets().add(Main.class.getResource("/CSS/dark-theme.css").toExternalForm());
            pane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

            ScrollPane scrollPane = new ScrollPane(pane);
            scrollPane.setFitToHeight(true);
            scrollPane.getStylesheets().add(Main.class.getResource("/CSS/dark-theme.css").toExternalForm());
            return scrollPane;
        });
        pagination.getStylesheets().add(Main.class.getResource("/CSS/dark-theme.css").toExternalForm());
        hot.getChildren().add(pagination);
    }
}
