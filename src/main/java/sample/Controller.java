package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button btnExplore;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    void onButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/DefaultNews.fxml"));
        Stage welcomeWindow = (Stage) btnExplore.getScene().getWindow();
        welcomeWindow.setScene(new Scene(root));
        welcomeWindow.setMaximized(true);
        welcomeWindow.setResizable(false);
    }
}

//    @FXML
//    void onButtonClicked(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/DefaultNews.fxml")));
//        Scene scene = btnExplore.getScene();
//        root.translateXProperty().set(scene.getHeight());
//        AnchorPane defaultNews = (AnchorPane) scene.getRoot();
//        defaultNews.getChildren().add(root);
//        Timeline timeline = new Timeline();
//        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
//        KeyFrame kf = new KeyFrame(Duration.seconds(2), kv);
//        timeline.getKeyFrames().add(kf);
//        timeline.setOnFinished(event1 -> {
//            defaultNews.getChildren().remove(welcomeRoot);
//        });
//        timeline.play();
//    }