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

public class PoliticsNewsController {

    @FXML
    private BorderPane politics;

    private final List<Article> politicsNewsList = new ArrayList<>();
    private final Categories categories = new Categories();
    private final Sites site = new Sites();

    private static final int ARTICLES_PER_PAGE = 10;
    private static final int MAX_COLS = 4;

    public PoliticsNewsController() throws IOException, ExecutionException, InterruptedException {
    }

    private ArrayList<Article> getPoliticsArticle() throws IOException {
        ArrayList<Article> politicsNewsList = new ArrayList<>();
        Article article;
        for (String link : categories.getPoliticsList()) {
            if (link.contains("vnexpress")) {
                article = site.getVnExpress(link);
                politicsNewsList.add(article);
            } else if (link.contains("zingnews")) {
                article = site.getZingNews(link);
                politicsNewsList.add(article);
            } else if (link.contains("nhandan")) {
                article = site.getNhanDan(link);
                politicsNewsList.add(article);
            } else if (link.contains("tuoitre")) {
                article = site.getTuoiTre(link);
                politicsNewsList.add(article);
            } else {
                article = site.getThanhNien(link);
                politicsNewsList.add(article);
            }
        }
        return politicsNewsList;
    }

    @FXML
    public void initialize() throws IOException {
        politicsNewsList.addAll(getPoliticsArticle());
        List<Node> articles = new ArrayList<>();

        for (int i = 0; i < politicsNewsList.size(); i++) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXML/ArticleCell.fxml"));
            AnchorPane anchorPane = loader.load();
            articles.add(anchorPane);

            ArticleCellController articleCellController = loader.getController();
            articleCellController.setArticle(politicsNewsList.get(i));
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
        politics.setCenter(pagination);
    }
}
