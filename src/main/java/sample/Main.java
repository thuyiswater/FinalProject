package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/HealthNews.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Vietnam Fast News");
        primaryStage.show();
//        Scraper scraper = new Scraper();
//        scraper.getHealth();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
