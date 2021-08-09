package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DefaultNewsController implements Initializable {

    @FXML
    private AnchorPane defaultNews;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnCovid;

    @FXML
    private Button btnPolitics;

    @FXML
    private Button btnBusiness;

    @FXML
    private Button btnTech;

    @FXML
    private Button btnHealth;

    @FXML
    private Button btnSports;

    @FXML
    private Button btnEntertainment;

    @FXML
    private Button btnWorld;

    @FXML
    private Button btnOthers;

    @FXML
    private AnchorPane content;


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void onHealthClicked(javafx.event.ActionEvent actionEvent) throws IOException {
        ScrollPane healthLayout = FXMLLoader.load(getClass().getResource("/FXML/HealthNews.fxml"));
        content.getChildren().setAll(healthLayout);
    }

}
