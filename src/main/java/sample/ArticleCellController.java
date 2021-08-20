package sample;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import java.io.IOException;

public class ArticleCellController {

    @FXML
    private ImageView img;

    @FXML
    private Hyperlink link;

    @FXML
    private Text summary;

    @FXML
    private Text pubDate;

    public void setArticle(Article article) throws IOException {
        if (article.getImage() == null || article.getImage().isEmpty()) {
            this.img.setImage(new Image("Image/logo_default.jpg"));
        } else {
            this.img.setImage(new Image(article.getImage()));
        }
        this.link.setText(article.getTitle());
        this.link.setOnMouseClicked(e -> {
                Stage stage = new Stage();
                WebView articlePage = new WebView();
                articlePage.getEngine().load(article.getLink());
                Scene scene = new Scene(articlePage);
                stage.setScene(scene);
                stage.show();
        });
        this.summary.setText(article.getSummary());
        this.pubDate.setText(article.getPubDate());
    }
}