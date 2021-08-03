package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class DefaultNewsController {

    @FXML
    private Label hotNews;
    @FXML
    private Label covid;
    @FXML
    private Label politics;
    @FXML
    private Label business;
    @FXML
    private Label tech;
    @FXML
    private Label health;
    @FXML
    private Label entertainment;
    @FXML
    private Label world;
    @FXML
    private Label others;
    @FXML
    private ScrollPane body;
    @FXML
    private GridPane newsLayout;
    @FXML
    private AnchorPane defaultNews;
}
