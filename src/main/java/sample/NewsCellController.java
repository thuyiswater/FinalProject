package sample;


import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewsCellController {

    @FXML
    private WebView link;

    private WebEngine engine;
    Scraper scraper;
    News news;

//    @Override
    public void loadContentNews(URL url, ResourceBundle resourceBundle) {
        engine = link.getEngine();
        link.getEngine().getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != Worker.State.SUCCEEDED) {
                System.out.println("Please wait a little");
            }
        });
        scraper = new Scraper();
//        try {
////            news = scraper.getVENews("https://vnexpress.net/bo-y-te-tp-hcm-duoc-phan-bo-vaccine-nhieu-nhat-ca-nuoc-4333640.html");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        loadNews();
    }
    public void loadNews() {
        engine.loadContent(news.getLink());
    }
}
