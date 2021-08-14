package com.company;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class MultithreadTrialRun {

    public static void main(String[] args) throws IOException {

//        This is test run on 8:26 08/08/2021
//        ArrayList<Article> thelist = new ArrayList<>();
//        TechnologyNews subject = new TechnologyNews(thelist);
//        thelist.addAll(subject.getZingNewsTechnology());
//        thelist.addAll(subject.getTuoiTreTechnology());


//        This is test run on 8:26 08/08/2021
//        show_article(thelist);
//        System.out.println("Tech list size: " + thelist.size());

        // ------------------ 09/08/2021------------TEST RUN------------ WORKING JUST FINE --- READJUSTED THE ARTICLE GETTER OF ZING DOWN TO 10
        long begin = System.currentTimeMillis();
        try {
            LatestNews latestSubject = new LatestNews();
            CovidNews covidSubject = new CovidNews();
            PoliticNews politicNews = new PoliticNews();
            BusinessNews businessNews = new BusinessNews();
            TechnologyNews subject = new TechnologyNews();
            HealthNews healthNews = new HealthNews();
            SportNews sportNews = new SportNews();
            EntertainmentNews entertainmentNews = new EntertainmentNews();
            WorldNews worldNews = new WorldNews();
            OtherNews otherNews = new OtherNews();

            latestSubject.getZingNewsLatest();
            latestSubject.getTuoiTreLatest();
            latestSubject.getVNExpressLatest();
            latestSubject.getNhanDanLatest();
            latestSubject.getThanhNienLatest();

            covidSubject.getZingNewsCovid();
            covidSubject.getTuoiTreCovid();
            covidSubject.getVNExpressCovid();
            covidSubject.getThanhNienCovid();
            covidSubject.getNhanDanCovid();

            politicNews.getZingNewsPolitic();
            politicNews.getTuoiTrePolitic();
            politicNews.getVNExpressPolitic();
            politicNews.getThanhNienPolitic();
            politicNews.getNhanDanPolitic();

            businessNews.getZingNewsBusiness();
            businessNews.getTuoiTreBusiness();
            businessNews.getVNExpressBusiness();
            businessNews.getThanhNienBusiness();
            businessNews.getNhanDanBusiness();

            subject.getZingNewsTechnology();
            subject.getTuoiTreTechnology();
            subject.getNhanDanTechnology();
            subject.getThanhNienTechnology();
            subject.getVNExpressTechnology();

            healthNews.getZingNewsHealth();
            healthNews.getTuoiTreHealth();
            healthNews.getVNExpressHealth();
            healthNews.getThanhNienHealth();
            healthNews.getNhanDanHealth();

            sportNews.getZingNewsSport();
            sportNews.getTuoiTreSport();
            sportNews.getVNExpressSport();
            sportNews.getThanhNienSport();
            sportNews.getNhanDanSport();

            entertainmentNews.getZingNewsEntertainment();
            entertainmentNews.getTuoiTreEntertainment();
            entertainmentNews.getVNExpressEntertainment();
            entertainmentNews.getThanhNienEntertainment();
            entertainmentNews.getNhanDanEntertainment();

            worldNews.getZingNewsWorld();
            worldNews.getTuoiTreWorld();
            worldNews.getVNExpressWorld();
            worldNews.getThanhNienWorld();
            worldNews.getNhanDanWorld();

            otherNews.getZingNewsOther();
            otherNews.getTuoiTreOther();
            otherNews.getVNExpressOther();
            otherNews.getThanhNienOther();
            otherNews.getNhanDanOther();

            long end = System.currentTimeMillis();
            System.out.println("Execution time: " + (end - begin));

        }
        catch (UnknownHostException e){
            System.err.println("Something wrong, please run again !");
        }
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
