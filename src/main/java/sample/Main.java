package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/sample.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Vietnam Fast News");
        primaryStage.show();
//        primaryStage.setMaximized(true);
//        primaryStage.setResizable(false);
//        Scraper scraper = new Scraper();
//        scraper.getWorld();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
