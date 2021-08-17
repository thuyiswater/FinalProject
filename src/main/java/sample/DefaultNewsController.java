package sample;

import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class DefaultNewsController {

    @FXML
    private BorderPane content;

    public void initialize() {
        try {
            Pane hotLayout = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/NewNews.fxml")));
            content.setCenter(hotLayout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onNewClicked() throws IOException {
        Pane newLayout = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/NewNews.fxml")));
        content.setCenter(newLayout);
    }

    @FXML
    void onCovidClicked() throws IOException {
        ScrollPane covidLayout = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/CovidNews.fxml")));
        content.setCenter(covidLayout);
    }

    @FXML
    void onPoliticsClicked() throws IOException {
        ScrollPane politicsLayout = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/PoliticsNews.fxml")));
        content.setCenter(politicsLayout);
    }

    @FXML
    void onBusinessClicked() throws IOException {
        ScrollPane businessLayout = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("/FXML/BusinessNews.fxml"))));
        content.setCenter(businessLayout);
    }

    @FXML
    void onTechClicked() throws IOException {
        ScrollPane techLayout = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("/FXML/TechNews.fxml"))));
        content.setCenter(techLayout);
    }

    @FXML
    void onHealthClicked() throws IOException {
        Pane healthLayout = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/HealthNews.fxml")));
        content.setCenter(healthLayout);
    }

    @FXML
    public void onSportsClicked() throws IOException {
        ScrollPane sportsLayout = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/SportsNews.fxml")));
        content.setCenter(sportsLayout);
    }

    @FXML
    public void onEntertainmentClicked() throws IOException {
        ScrollPane entertainmentLayout = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/EntertainmentNews.fxml")));
        content.setCenter(entertainmentLayout);
    }

    @FXML
    void onWorldClicked() throws IOException {
        ScrollPane worldLayout = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("/FXML/WorldNews.fxml"))));
        content.setCenter(worldLayout);
    }

    @FXML
    void onOthersClicked() throws IOException {
        ScrollPane othersLayout = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("/FXML/OthersNews.fxml"))));
        content.setCenter(othersLayout);
    }
}