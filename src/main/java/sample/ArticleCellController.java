package sample;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

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
            Image extraImage = new Image("Image/logo_default.jpg");
            this.img.setImage(extraImage);
        } else {
            Image mainImage = new Image(article.getImage());
            this.img.setImage(mainImage);
        }
        this.link.setText(article.getTitle());
        this.link.setOnMouseClicked(e -> {
                Stage stage = new Stage();
                WebView articlePage = new WebView();
                articlePage.getEngine().load(article.getLink());
                Scene scene = new Scene(articlePage);
//                stage.setMaximized(true);
                stage.setScene(scene);
                stage.show();
        });
        this.summary.setText(article.getSummary());
        this.pubDate.setText(article.getPubDate());
    }
}