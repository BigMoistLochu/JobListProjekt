package com.example.listjobsproject.scrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class NoFluffJobs implements Runnable{



    @Override
    public void run() {

        try
        {
            Document doc = Jsoup.connect("https://nofluffjobs.com/pl/Java?page=1&criteria=seniority%3Djunior").get();
            String s = doc.select("#nfjPostingListItem-junior-java-developer-bersi-Bydgoszczds").attr("href");
           Elements e =  doc.getElementsByAttributeStarting("href");
            for (Element p:e) {
                System.out.println(p);
            }
        }
        catch(IOException e){
            System.out.println("blad sciagania z ...(podaj strone), potem to bedzie log");
        }

    }
}
