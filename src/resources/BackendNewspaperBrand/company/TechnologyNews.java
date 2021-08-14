package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.ArrayList;

public class TechnologyNews {

    private ArrayList<Article> articleContainer;

    public ArrayList<Article> getArticleContainer() {
        return articleContainer;
    }

    public void setArticleContainer(ArrayList<Article> articleContainer) {
        this.articleContainer = articleContainer;
    }

    //Parameterized Constructor
    TechnologyNews(ArrayList<Article> value_holder){
        this.articleContainer = value_holder;
    }

    // commented out at 8:28 09/08/2021 !!! work just fine
    TechnologyNews(){
        //Initialize value, important !
        this.articleContainer = new ArrayList<>();
    }

    //Test 1 at 8:24 09/07/2021 -> changing from return value into void, previously return value was ArrayList<Article>
    public void getZingNewsTechnology() throws IOException {

        String link = "https://zingnews.vn/cong-nghe.html";
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
        System.out.println("Completed !");

    }

    public void getTuoiTreTechnology() throws IOException {

        String link = "https://congnghe.tuoitre.vn/";
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

    public void getVNExpressTechnology() throws IOException {


        String link = "https://vnexpress.net/so-hoa";
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

    public void getThanhNienTechnology() throws IOException {

        String link = "https://thanhnien.vn/cong-nghe/";
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

    public void getNhanDanTechnology() throws IOException {

        String linkserver = "https://nhandan.vn/khoahoc-congnghe";
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
