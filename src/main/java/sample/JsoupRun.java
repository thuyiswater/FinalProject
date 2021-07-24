package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupRun {

    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("https://www.imdb.com/chart/top/").timeout(6000).get();

        Elements body = doc.select("tbody.lister-list");

        for(Element e: body.select("tr")){
            String title = e.select("td.posterColumn img").attr("alt");
            System.out.println("The title of the movie: " + title);
            String year = e.select("td.titleColumn span.secondaryInfo").text().replaceAll("[^\\d]","");
            System.out.println("Year aired: " + year);
            String rate = e.select("td.ratingColumn.imdbRating").text().trim();
            System.out.println("Movie rating: " + rate);
            System.out.println("\n\n\n");
        }








    }



}
