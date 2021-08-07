package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DefaultNewsController implements Initializable {

    @FXML
    private AnchorPane defaultNews;

    @FXML
    private Button btnNew;

    @FXML
    private Label health;

    @FXML
    private Button btnHealth;

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
