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

public class CovidNewsController {
    @FXML
    private BorderPane covid;

    private final List<Article> covidNewsList = new ArrayList<>();
    private final Categories categories = new Categories();
    private final Sites site = new Sites();

    private static final int ARTICLES_PER_PAGE = 10;
    private static final int MAX_COLS = 4;

    public CovidNewsController() throws IOException, ExecutionException, InterruptedException {
    }

    private ArrayList<Article> getCovidArticle() throws IOException {
        ArrayList<Article> covidNewsList = new ArrayList<>();
        Article article;
        for (String link : categories.getCovidList()) {
            if (link.contains("vnexpress")) {
                article = site.getVnExpress(link);
                covidNewsList.add(article);
            } else if (link.contains("zingnews")) {
                article = site.getZingNews(link);
                covidNewsList.add(article);
            } else if (link.contains("nhandan")) {
                article = site.getNhanDan(link);
                covidNewsList.add(article);
            } else if (link.contains("tuoitre")) {
                article = site.getTuoiTre(link);
                covidNewsList.add(article);
            } else {
                article = site.getThanhNien(link);
                covidNewsList.add(article);
            }
        }
        return covidNewsList;
    }

    @FXML
    public void initialize() throws IOException {
        covidNewsList.addAll(getCovidArticle());
        List<Node> articles = new ArrayList<>();

        for (Article article : covidNewsList) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXML/ArticleCell.fxml"));
            AnchorPane anchorPane = null;
            anchorPane = loader.load();
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
        covid.setCenter(pagination);
    }
}