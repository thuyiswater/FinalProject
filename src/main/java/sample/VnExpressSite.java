package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VnExpressSite implements GetArticleByCategories {
    private List<String> healthList = new ArrayList<>();

    public VnExpressSite() {
    }

    @Override
    public List<String> getHealth() throws IOException {
        Document document = Jsoup.connect("https://vnexpress.net/suc-khoe").get();
        healthList = document.select("h3 > a[href$=.html]")
                .stream().map(p -> p.attr("abs:href"))
                .limit(10)
                .collect(Collectors.toList());
        return healthList;
    }
}
