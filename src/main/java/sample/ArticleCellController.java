package sample;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;

public class ArticleCellController {

    @FXML
    private ImageView img;

    @FXML
    private ImageView brand;

    @FXML
    private Text summary;

    @FXML
    private Text pubDate;


    private News news;

    //    Scraper scraper = new Scraper();
//    @FXML
//    void initialize() throws IOException {
//        news = scraper.getVENews();

    public void setNews(News news) throws IOException {
        this.news = news;
        Image image = new Image("Image/logo_default.jpg");
        Image extraImage = new Image("Image/logo_default.jpg");
        this.brand.setImage(image);
        this.pubDate.setText(news.getPubDate());
        this.summary.setText(news.getSummary());
        if (news.getImage() == null || news.getImage().isEmpty()) {
            this.img.setImage(extraImage);
        } else {
            Image mainImage = new Image(news.getImage());
            this.img.setImage(mainImage);
        }
    }
}