package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.ArrayList;

public class HealthNews {

    private ArrayList<Article> articleContainer;

    public ArrayList<Article> getArticleContainer() {
        return articleContainer;
    }

    public void setArticleContainer(ArrayList<Article> articleContainer) {
        this.articleContainer = articleContainer;
    }

    //Empty Constructor
    HealthNews(){
        //Initialize value, important !
        this.articleContainer = new ArrayList<>();
    }

    public void getZingNewsHealth() throws IOException {

        String link = "https://zingnews.vn/suc-khoe.html";
        Document doc = Jsoup.connect(link).get();
        int i = 1;

        for(Element e : doc.select("article")){

            if(i > 10){
                break;
            }

            Article healthObject = new Article();
            healthObject.setTitle(e.getElementsByClass("article-title").text());
            healthObject.setPubDate(e.getElementsByClass("friendly-time").text());
            healthObject.setImage(e.getElementsByTag("img").attr("data-src"));
            healthObject.setLink(add_https(e.getElementsByTag("a").attr("href")));
            healthObject.setSummary(e.getElementsByClass("article-summary").text());

            this.articleContainer.add(healthObject);
            healthObject = null;
            i += 1;
        }
    }

    public void getTuoiTreHealth() throws IOException {

        String link = "https://tuoitre.vn/suc-khoe.htm";
        Document doc = Jsoup.connect(link).get();

        int i = 1;

        for(Element e : doc.getElementsByClass("news-item")){


            if( i > 10){
                break;
            }

            //Create new object to store value
            Article healthObject = new Article();

            //Set the value
            healthObject.setTitle(e.getElementsByClass("title-news").text());// or getElementsByTag("a").attr("title"))
            healthObject.setSummary(e.getElementsByClass("sapo need-trimline").text());
            healthObject.setImage(e.getElementsByTag("img").attr("src"));
            healthObject.setLink((e.getElementsByTag("a").attr("abs:href")));
            Document testing = Jsoup.connect(healthObject.getLink()).timeout(3000).get();
            String value_holder = testing.getElementsByClass("date-time").text();
            healthObject.setPubDate(value_holder);
            //Add to the list
            this.articleContainer.add(healthObject);

            //Erase the object
            healthObject = null;
            i += 1;

        }

    }

    public void getVNExpressHealth() throws IOException {


        String link = "https://vnexpress.net/suc-khoe";
        Document doc = Jsoup.connect(link).get();

        int i = 1;
        for(Element e : doc.select("article")){

            if( i > 10){
                break;
            }

            //Create new object to store value
            Article healthObject = new Article();

            //Load value
            healthObject.setTitle("The title: " + e.getElementsByClass("title-news").text());
            healthObject.setSummary("Article Summary: " + e.getElementsByClass("description").text());
            healthObject.setPubDate("Date posted: " + doc.getElementsByClass("time-now").text());
            healthObject.setLink("The article link: " + e.getElementsByTag("a").attr("href"));
            healthObject.setImage("The image src: " + e.getElementsByTag("img").attr("src"));
            //Set the value

            //Add to the list
            this.articleContainer.add(healthObject);

            //Erase the object
            healthObject = null;
            i += 1;

        }

    }

    public void getThanhNienHealth() throws IOException {

        String link = "https://thanhnien.vn/suc-khoe/";
        Document doc = Jsoup.connect(link).get();

        int i = 1;
        String time = "";

        for(Element g : doc.getElementsByClass("story--primary")){

            Article healthObject = new Article();
            String article_pic_Src = "";

            if(i > 10){
                break;
            }

            if ((g.getElementsByClass("timebox").text()).isEmpty()) {

                time = (doc.getElementsByTag("time").first().text());

            }

            if((g.getElementsByTag("img").attr("data-src")).isEmpty()){
                article_pic_Src = (g.getElementsByTag("img").attr("src"));
            }
            else{
                article_pic_Src = (g.getElementsByTag("img").attr("data-src"));
            }
            //Load data into temporary object
            String articleLink = g.getElementsByTag("a").attr("href");
            articleLink = remove_https(articleLink);
            articleLink = "https://thanhnien.vn" + articleLink;
            healthObject.setLink(articleLink);
            healthObject.setImage(article_pic_Src);
            healthObject.setTitle(g.getElementsByTag("a").attr("title"));
            healthObject.setPubDate("Article time: "  + g.getElementsByClass("meta").select("time").text());

            //Add that object in the list of the HealthNews Class
            this.articleContainer.add(healthObject);
            healthObject = null; //Reset the object to free memory

            i += 1;


        }

    }

    public void getNhanDanHealth() throws IOException {

        String linkserver = "https://nhandan.vn/tag/chamsocsuckhoe-13170";
        Document doc = Jsoup.connect(linkserver).get();
        int i = 1;

        for (Element e : doc.select("article")) {

            if (i > 10) {
                break;
            }
            //Create temporary object
            Article healthObject = new Article();

            //Load the data into the object
            healthObject.setTitle(e.getElementsByTag("a").attr("title"));
            String art_link = e.getElementsByTag("a").attr("href");
            art_link = add_https(art_link);
            healthObject.setLink(art_link);
            healthObject.setImage(e.getElementsByTag("img").attr("data-src"));
            Document testing = Jsoup.connect(art_link).timeout(3000).get();
            healthObject.setPubDate(testing.getElementsByClass("box-date pull-left").text());

            //Add the object into the list of the class
            this.articleContainer.add(healthObject);
            healthObject = null; //Reset the object to free memory

            i += 1;

        }

    }

    //Function dedicated for Zing webpage scrapping only !!!
    public static String add_https(String target){
        return ("https://zingnews.vn" + target ) ;
    }

    public String remove_https(String target){
        return target.replace("https://","");
    }



}
