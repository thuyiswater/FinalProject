package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class TrialRun {

    public static void main(String[] args) throws IOException {


        LatestNews latestNews = new LatestNews();
        CovidNews covidSubject = new CovidNews();
        PoliticNews politicNews = new PoliticNews();
        BusinessNews businessNews = new BusinessNews();
        TechnologyNews technologyNews = new TechnologyNews();
        HealthNews healthNews = new HealthNews();
        SportNews sportNews = new SportNews();
        EntertainmentNews entertainmentNews = new EntertainmentNews();
        WorldNews worldNews = new WorldNews();
        OtherNews otherNews = new OtherNews();

        //Testing NhanDan Newspaper brand
//        latestNews.getNhanDanLatest(); //Completed
//        covidSubject.getNhanDanCovid(); // Completed
//        politicNews.getNhanDanPolitic(); //Completed
//        businessNews.getNhanDanBusiness(); //Completed
//        technologyNews.getNhanDanTechnology(); // Completed
//        healthNews.getNhanDanHealth(); // Completed
//        sportNews.getNhanDanSport(); // Completed
//        entertainmentNews.getNhanDanEntertainment(); // Completed
//        worldNews.getNhanDanWorld(); // Completed
//        otherNews.getNhanDanOther(); //Completed

        latestNews.getThanhNienLatest();

        ArrayList<Article> list_hold = new ArrayList<>();
        list_hold.addAll(latestNews.getArticleContainer());

        show_article(list_hold);

    }
    public static void show_article(ArrayList<Article> list_hold){


        int number = 1;

        for (Article a : list_hold){
            System.out.println("----------------------------");
            System.out.println("This is article number: " + number);
            System.out.println("Title: " + a.getTitle());
            System.out.println("Link: " + a.getLink());
            System.out.println("Image src: " + a.getImage());
            System.out.println("Summary: " + a.getSummary());
            System.out.println("Time posted is: " + a.getPubDate());



            number += 1;
            System.out.println("\n\n\n");
        }


    }

}
