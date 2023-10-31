package com.example.listjobsproject.scrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class NoFluffJobs implements Runnable{



    @Override
    public void run() {

        try
        {
            Document doc = Jsoup.connect("https://nofluffjobs.com/pl/Java?page=1&criteria=seniority%3Djunior").get();
            String s = doc.select("#nfjPostingListItem-junior-java-developer-bersi-Bydgoszcz").attr("href");
            System.out.println(s);
        }
        catch(IOException e){
        }

    }
}
