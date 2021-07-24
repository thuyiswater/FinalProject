package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class NewsFullViewController {
    @FXML
    private Label link;
    @FXML
    private Label title;
    @FXML
    private Label publishedAt;
    @FXML
    private Text description;



    public void setNews(News news) {
        title.setText(news.getTitle());
        publishedAt.setText(news.getPubDate());
        link.setText(news.getLink());
        description.setText(news.getDescription());
    }

}
