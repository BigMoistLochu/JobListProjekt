package com.example.listjobsproject.scrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class NoFluffJobs implements Runnable{



    @Override
    public void run() {

        try
        {
            Document doc = Jsoup.connect("http://example.com/").get();
        }
        catch(IOException e){

        }

    }
}
