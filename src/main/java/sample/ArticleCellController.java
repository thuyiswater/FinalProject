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
    private Text summary;

    @FXML
    private Text pubDate;


    private Article news;

    public void setArticle(Article article) throws IOException {
        this.news = article;
        Image extraImage = new Image("Image/logo_default.jpg");
        this.pubDate.setText(article.getPubDate());
        this.summary.setText(article.getSummary());
        if (article.getImage() == null || article.getImage().isEmpty()) {
            this.img.setImage(extraImage);
        } else {
            Image mainImage = new Image(article.getImage());
            this.img.setImage(mainImage);
        }
    }
}