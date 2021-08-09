package sample;


import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class NewsCellController {

    @FXML
    private WebView link;

    private WebEngine engine;
    private Article article;

    public NewsCellController(Article article) {
        this.article = article;
    }

    public void loadContentNews() {
        engine = link.getEngine();
        link.getEngine().getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != Worker.State.SUCCEEDED) {
                System.out.println("Please wait a little");
            }
        });
        loadNews();
    }
    public void loadNews() {
        engine.loadContent(article.getLink());
    }
}
