package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class EntertainmentNews {

    private ArrayList<Article> articleContainer;

    public ArrayList<Article> getArticleContainer() {
        return articleContainer;
    }

    public void setArticleContainer(ArrayList<Article> articleContainer) {
        this.articleContainer = articleContainer;
    }

    //Empty Constructor
    EntertainmentNews(){
        //Initialize value, important !
        this.articleContainer = new ArrayList<>();
    }

    public void getZingNewsEntertainment() throws IOException {

        String link = "https://zingnews.vn/giai-tri.html";
        Document doc = Jsoup.connect(link).get();
        int i = 1;

        for(Element e : doc.select("article")){

            if(i > 10){
                break;
            }

            Article temporaryObject = new Article();
            temporaryObject.setTitle(e.getElementsByClass("article-title").text());
            temporaryObject.setPubDate(e.getElementsByClass("friendly-time").text());
            temporaryObject.setImage(e.getElementsByTag("img").attr("data-src"));
            temporaryObject.setLink(add_https(e.getElementsByTag("a").attr("href")));
            temporaryObject.setSummary(e.getElementsByClass("article-summary").text());

            this.articleContainer.add(temporaryObject);
            temporaryObject = null;
            i += 1;
        }
    }

    public void getTuoiTreEntertainment() throws IOException {

        String link = "https://tuoitre.vn/giai-tri.htm";
        Document doc = Jsoup.connect(link).get();

        int i = 1;

        for(Element e : doc.getElementsByClass("news-item")){


            if( i > 10){
                break;
            }

            //Create new object to store value
            Article temporaryObject = new Article();

            //Set the value
            temporaryObject.setTitle(e.getElementsByClass("title-news").text());// or getElementsByTag("a").attr("title"))
            temporaryObject.setSummary(e.getElementsByClass("sapo need-trimline").text());
            temporaryObject.setImage(e.getElementsByTag("img").attr("src"));
            temporaryObject.setLink((e.getElementsByTag("a").attr("abs:href")));
            Document testing = Jsoup.connect(temporaryObject.getLink()).timeout(3000).get();
            String value_holder = testing.getElementsByClass("date-time").text();
            temporaryObject.setPubDate(value_holder);
            //Add to the list
            this.articleContainer.add(temporaryObject);

            //Erase the object
            temporaryObject = null;
            i += 1;

        }

    }

    public void getVNExpressEntertainment() throws IOException {


        String link = "https://vnexpress.net/giai-tri";
        Document doc = Jsoup.connect(link).get();

        int i = 1;
        for(Element e : doc.select("article")){

            if( i > 10){
                break;
            }

            //Create new object to store value
            Article temporaryObject = new Article();

            //Load value
            temporaryObject.setTitle("The title: " + e.getElementsByClass("title-news").text());
            temporaryObject.setSummary("Article Summary: " + e.getElementsByClass("description").text());
            temporaryObject.setPubDate("Date posted: " + doc.getElementsByClass("time-now").text());
            temporaryObject.setLink("The article link: " + e.getElementsByTag("a").attr("href"));
            temporaryObject.setImage("The image src: " + e.getElementsByTag("img").attr("src"));
            //Set the value

            //Add to the list
            this.articleContainer.add(temporaryObject);

            //Erase the object
            temporaryObject = null;
            i += 1;

        }

    }

    public void getThanhNienEntertainment() throws IOException {

        String link = "https://thanhnien.vn/giai-tri/";
        Document doc = Jsoup.connect(link).get();

        int i = 1;
        String time = "";

        for(Element g : doc.getElementsByClass("story--primary")){

            Article temporaryObject = new Article();
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
            temporaryObject.setLink(articleLink);
            temporaryObject.setImage(article_pic_Src);
            temporaryObject.setTitle(g.getElementsByTag("a").attr("title"));
            temporaryObject.setPubDate("Article time: "  + g.getElementsByClass("meta").select("time").text());

            //Add that object in the list of the HealthNews Class
            this.articleContainer.add(temporaryObject);
            temporaryObject = null; //Reset the object to free memory

            i += 1;


        }

    }

    public void getNhanDanEntertainment() throws IOException {

        String linkserver = "https://nhandan.vn/giai-tri/";
        Document doc = Jsoup.connect(linkserver).get();
        int i = 1;

        for (Element e : doc.select("article")) {

            if (i > 10) {
                break;
            }
            //Create temporary object
            Article temporaryObject = new Article();

            //Load the data into the object
            temporaryObject.setTitle(e.getElementsByTag("a").attr("title"));
            String art_link = e.getElementsByTag("a").attr("href");
            art_link = add_https(art_link);
            temporaryObject.setLink(art_link);
            temporaryObject.setImage(e.getElementsByTag("img").attr("data-src"));
            Document testing = Jsoup.connect(art_link).timeout(3000).get();
            temporaryObject.setPubDate(testing.getElementsByClass("box-date pull-left").text());

            //Add the object into the list of the class
            this.articleContainer.add(temporaryObject);
            temporaryObject = null; //Reset the object to free memory

            i += 1;

        }

    }

    //Function used dedicated for Zing webpage ONLY !!!
    public static String add_https(String target){
        return ("https://zingnews.vn" + target ) ;
    }

    public String remove_https(String target){
        return target.replace("https://","");
    }




}
