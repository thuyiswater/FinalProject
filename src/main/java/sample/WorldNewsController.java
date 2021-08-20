package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class WorldNewsController {
    @FXML
    private BorderPane world;

    private List<Article> worldNewsList = new ArrayList<>();
    private final Categories categories = new Categories();
    private final Sites site = new Sites();

    private static final int ARTICLES_PER_PAGE = 10;
    private static final int MAX_COLS = 4;

    public WorldNewsController() throws IOException, ExecutionException, InterruptedException {
    }

    private ArrayList<Article> getWorldArticle() throws IOException {
        ArrayList<Article> worldNewsList = new ArrayList<>();
        Article article;
        for (String link : categories.getWorldList()) {
            if (link.contains("vnexpress")) {
                article = site.getVnExpress(link);
                worldNewsList.add(article);
            } else if (link.contains("zingnews")) {
                article = site.getZingNews(link);
                worldNewsList.add(article);
            } else if (link.contains("nhandan")) {
                article = site.getNhanDan(link);
                worldNewsList.add(article);
            } else if (link.contains("tuoitre")) {
                article = site.getTuoiTre(link);
                worldNewsList.add(article);
            } else {
                article = site.getThanhNien(link);
                worldNewsList.add(article);
            }
        }
        return worldNewsList;
    }

    @FXML
    public void initialize() throws IOException {
        worldNewsList.addAll(getWorldArticle());
        List<Node> articles = new ArrayList<>();

        for (Article article : worldNewsList) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXML/ArticleCell.fxml"));
            AnchorPane anchorPane = loader.load();
            articles.add(anchorPane);

            ArticleCellController articleCellController = loader.getController();
            articleCellController.setArticle(article);
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
            pane.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("/CSS/dark-theme.css")).toExternalForm());
            pane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

            ScrollPane scrollPane = new ScrollPane(pane);
            scrollPane.setFitToHeight(true);
            scrollPane.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("/CSS/dark-theme.css")).toExternalForm());
            return scrollPane;
        });
        pagination.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("/CSS/dark-theme.css")).toExternalForm());
        world.setCenter(pagination);
    }
}
