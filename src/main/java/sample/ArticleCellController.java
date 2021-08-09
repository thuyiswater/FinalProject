package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Node;

import java.io.IOException;

public class ArticleCellController {

    @FXML
    private AnchorPane body;

    @FXML
    private ImageView img;

    @FXML
    private Hyperlink link;

    @FXML
    private Text summary;

    @FXML
    private Text pubDate;

    public void setArticle(Article article) throws IOException {
        Image extraImage = new Image("Image/logo_default.jpg");
        if (article.getImage() == null || article.getImage().isEmpty()) {
            this.img.setImage(extraImage);
        } else {
            Image mainImage = new Image(article.getImage());
            this.img.setImage(mainImage);
        }
        this.link.setText(article.getTitle());
        this.link.setOnMouseClicked(e -> {
            Stage stage = new Stage();
            WebView articlePage = new WebView();
            try {
                Document document = Jsoup.connect(article.getLink()).get();
                document.childNodes()
                        .stream()
                        .filter(node -> node instanceof DocumentType)
                        .findFirst()
                        .ifPresent(Node::remove);
                System.out.println(document);
                articlePage.getEngine().loadContent(document.toString());
                Scene scene = new Scene(articlePage);
                stage.setMaximized(true);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        this.summary.setText(article.getSummary());
        this.pubDate.setText(article.getPubDate());
    }
}