package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DefaultNewsController implements Initializable {

    @FXML
    private AnchorPane content;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ScrollPane hotLayout = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/NewNews.fxml")));
            content.getChildren().add(hotLayout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onNewClicked() throws IOException {
        ScrollPane healthLayout = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/NewNews.fxml")));
        content.getChildren().add(healthLayout);
    }

    @FXML
    void onCovidClicked() throws IOException {
        ScrollPane covidLayout = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/CovidNews.fxml")));
        content.getChildren().add(covidLayout);
    }

    @FXML
    void onPoliticsClicked() throws IOException {
        ScrollPane politicsLayout = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/PoliticsNews.fxml")));
        content.getChildren().add(politicsLayout);
    }

    @FXML
    void onBusinessClicked() throws IOException {
        ScrollPane businessLayout = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("/FXML/BusinessNews.fxml"))));
        content.getChildren().add(businessLayout);
    }

    @FXML
    void onTechClicked() throws IOException {
        ScrollPane techLayout = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("/FXML/TechNews.fxml"))));
        content.getChildren().add(techLayout);
    }

    @FXML
    void onHealthClicked() throws IOException {
        ScrollPane healthLayout = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/HealthNews.fxml")));
        content.getChildren().add(healthLayout);
    }

    @FXML
    public void onSportsClicked() throws IOException {
        ScrollPane sportsLayout = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/SportsNews.fxml")));
        content.getChildren().add(sportsLayout);
    }

    @FXML
    public void onEntertainmentClicked() throws IOException {
        ScrollPane entertainmentLayout = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/EntertainmentNews.fxml")));
        content.getChildren().add(entertainmentLayout);
    }

    @FXML
    void onWorldClicked() throws IOException {
        ScrollPane worldLayout = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("/FXML/WorldNews.fxml"))));
        content.getChildren().add(worldLayout);
    }

    @FXML
    void onOthersClicked() throws IOException {
        ScrollPane othersLayout = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("/FXML/OthersNews.fxml"))));
        content.getChildren().add(othersLayout);
    }
}
