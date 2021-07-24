package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
       Scraper scraper = new Scraper();
//       scraper.getZingNews("https://zingnews.vn/sieu-thi-gap-kho-vi-cu-3-ngay-mat-gan-1-ty-dong-tien-xet-nghiem-post1242249.html");
       scraper.getVENews("https://vnexpress.net/kich-ban-80-000-f0-o-tp-hcm-4329099.html");
//       scraper.getNDNews("https://nhandan.vn/tin-tuc-y-te/ngay-23-7-ca-nuoc-co-7-307-ca-covid-19-656488/");
//       scraper.getTNNews("https://thanhnien.vn/thoi-su/tu-6-gio-sang-247-ha-noi-gian-cach-xa-hoi-theo-nguyen-tac-cua-chi-thi-16-1419447.html");
//      scraper.getTTNews("https://tuoitre.vn/pho-nong-hoi-gui-trao-den-cac-be-mo-coi-khuyet-tat-trong-ngay-gian-cach-20210723183234568.htm");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
