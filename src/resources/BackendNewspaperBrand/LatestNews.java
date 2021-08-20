package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class LatestNews {

    private ArrayList<Article> articleContainer;

    public ArrayList<Article> getArticleContainer() {
        return articleContainer;
    }

    public void setArticleContainer(ArrayList<Article> articleContainer) {
        this.articleContainer = articleContainer;
    }

    //Empty Constructor
    LatestNews(){
        //Initialize value, important !, the object's arraylist will always be null pointer if we don't have this initializer
        this.articleContainer = new ArrayList<>();
    }

    public void getZingNewsLatest() throws IOException {

        String link = "https://zingnews.vn/";
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

    public void getTuoiTreLatest() throws IOException {

        String link = "https://tuoitre.vn/";
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

    public void getVNExpressLatest() throws IOException {


        String link = "https://vnexpress.net/tin-tuc-24h";
        Document doc = Jsoup.connect(link).get();

        int i = 1;
        for(Element e : doc.select("article")){

            if( i > 10){
                break;
            }

            //Create new object to store value
            Article temporaryObject = new Article();

            //Load value
            temporaryObject.setTitle(e.getElementsByClass("title-news").text());
            temporaryObject.setSummary(e.getElementsByClass("description").text());
            temporaryObject.setPubDate(doc.getElementsByClass("time-now").text());
            temporaryObject.setLink(e.getElementsByTag("a").attr("href"));
            temporaryObject.setImage(e.getElementsByTag("img").attr("src"));
            //Set the value

            //Add to the list
            this.articleContainer.add(temporaryObject);

            //Erase the object
            temporaryObject = null;
            i += 1;

        }

    }

    public void getThanhNienLatest() throws IOException {

        String link = "https://thanhnien.vn/";
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
            System.out.println(g);
            //Load data into temporary object
            String articleLink = g.getElementsByTag("a").attr("abs:href");
            articleLink = remove_https(articleLink);
            temporaryObject.setLink(articleLink);
            temporaryObject.setImage(article_pic_Src);
            temporaryObject.setTitle(g.getElementsByTag("a").attr("title"));
            temporaryObject.setPubDate(g.getElementsByClass("meta").select("time").text());

            //Add that object in the list of the HealthNews Class
            this.articleContainer.add(temporaryObject);
            temporaryObject = null; //Reset the object to free memory

            i += 1;


        }

    }

    public void getNhanDanLatest() throws IOException {

        String linkserver = "https://nhandan.vn/";
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
            //art_link = add_https(art_link);
            art_link = nhanDan_add_https(art_link);
            temporaryObject.setLink(art_link);
            temporaryObject.setImage(e.getElementsByTag("img").attr("data-src"));
            Document testing = Jsoup.connect(art_link).get();
            //temporaryObject.setPubDate(testing.getElementsByTag("article").select("box-meta-small").text());
            temporaryObject.setPubDate((testing.getElementsByClass("box-date pull-left").text()));
            if(temporaryObject.getPubDate().isEmpty()){
                temporaryObject.setPubDate(testing.getElementsByClass("box-date uk-text-center").text());
            }
            temporaryObject.setSummary(testing.getElementsByTag("p").text());

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

    public static String nhanDan_add_https(String target){
        return ("https://nhandan.vn" + target);

    }

    public String remove_https(String target){
        return target.replace("https://","");
    }

}
