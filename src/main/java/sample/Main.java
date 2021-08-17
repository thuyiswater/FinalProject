package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {

//        Parent root = FXMLLoader.load(getClass().getResource("/FXML/sample.fxml"));
//        Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Vietnam Fast News");
//        primaryStage.show();
//        primaryStage.setMaximized(true);
//        primaryStage.setResizable(false);


        Scraper scraper = new Scraper();
        long start = System.currentTimeMillis();
        scraper.getNew();
        scraper.getCovid();
        scraper.getPolitics();
        scraper.getBusiness();
        scraper.getTech();
        scraper.getHealth();
        scraper.getSports();
        scraper.getEntertainment();
        scraper.getWorld();
        scraper.getOthers();
        long end = System.currentTimeMillis();

        System.out.println("Execution duration: " + (end - start));

        System.out.println("The size of new: " + scraper.getNew().size());
        System.out.println("The size of covid: " + scraper.getCovid().size());
        System.out.println("The size of politic: " + scraper.getPolitics().size());
        System.out.println("The size of business: " + scraper.getBusiness().size());
        System.out.println("The size of technology: "  + scraper.getTech().size());
        System.out.println("The size of health: " + scraper.getHealth().size());
        System.out.println("The size of sport: " + scraper.getSports().size());
        System.out.println("The size of entertainment: " + scraper.getEntertainment().size());
        System.out.println("The size of world: " + scraper.getWorld().size());
        System.out.println("The size of other: " + scraper.getOthers().size());



        System.exit(-1);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
