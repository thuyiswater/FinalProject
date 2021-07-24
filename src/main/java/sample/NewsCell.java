package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class NewsCell {
    @FXML
    private GridPane gridPane;
    @FXML
    private Label link;
    @FXML
    private Label title;
    @FXML
    private Label pubDate;

    public NewsCell() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/NewsCell.fxml"));
        loader.setController(this);
        loader.load();
    }

    public void setContent(News news) {
        this.link.setText(news.getLink());
        this.title.setText(news.getTitle());

        if (news.getPubDate() != null) {
            SimpleDateFormat date = new SimpleDateFormat("EE dd MM YYYY, HH:mm");
            this.pubDate.setText(date.format(news.getPubDate()));
        }

    }

    public GridPane getGridPane() {
        return gridPane;
    }
}
