package com.company;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;


public class ZingPage {

    public static void main(String[] args) throws IOException {

        String link = "https://zingnews.vn/";

        Document doc = Jsoup.connect(link).timeout(6000).get();
        Element holder = doc.select("article").first();
        System.out.println(holder);
        System.out.println("\n\n\n");
        System.out.println("The title: " + holder.getElementsByClass("article-title").text());
        System.out.println("Time posted: " + holder.getElementsByClass("friendly-time").text());
        System.out.println("date: " + holder.getElementsByClass("date").text());
        System.out.println("The category of the article: " + holder.getElementsByTag("a").attr("title"));
        System.out.println("\n\n\n");

        int i = 1;

        for(Element e : doc.select("article")){
            System.out.println("This is article number: " + i);
            System.out.println("The article header: " + e.getElementsByClass("article-title").text());
            System.out.println("Date posted: " + e.getElementsByClass("date").text());
            System.out.println("Time posted: " + e.getElementsByClass("time").text());
            System.out.println("Duration: " + e.getElementsByClass("friendly-time").text());
            System.out.println("Category of the post: " + e.getElementsByTag("a").attr("title"));
            System.out.println("Article Summary: " + e.getElementsByClass("article-summary").text());

            i += 1;
            System.out.println("\n\n\n");
        }

        //System.out.println(doc.getElementsByAttribute("href"));
//           for(int i = 0 ; i < 50 ; i++){
//            //System.out.println(doc.select("article").get(i));
//
//               System.out.println(doc.select("p.article-title").get(i));
//
//               System.out.println(doc.select("p.article-meta").get(i));
//
//               System.out.println(doc.select("p.article-count").get(i));
//
//               System.out.println(doc.select("p.article-summary").get(i));
//
//               System.out.println("\n\n\n\n");
//
//
//        }
        //System.out.println(doc.select("p.article-title").get(1));
//        for(int i = 0 ; i < 50 ; i++){
//            //System.out.println(doc.select("article").get(i));
//            System.out.println(doc.select("p.article-title").get(i));
//            System.out.println(doc.select("span.date").get(i));
//            System.out.println("\n\n\n");
//        }

        //System.out.println(doc.select("span.date").get(1));


    }
}

