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
    private Text title;

    @FXML
    private Text pubDate;


    private Article article;

    public void setArticle(Article article) throws IOException {
        this.article = article;
        Image extraImage = new Image("Image/logo_default.jpg");
        if (article.getImage() == null || article.getImage().isEmpty()) {
            this.img.setImage(extraImage);
        } else {
            Image mainImage = new Image(article.getImage());
            this.img.setImage(mainImage);
        }
        this.title.setText(article.getTitle());
        this.summary.setText(article.getSummary());
        this.pubDate.setText(article.getPubDate());
    }
}