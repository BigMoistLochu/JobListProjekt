package com.example.listjobsproject.scrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class PracujPl implements Runnable{
    @Override
    public void run() {

        try
        {
            Document doc = Jsoup.connect("http://pracuj.com").get();

        }
        catch(IOException e){
            System.out.println("blad sciagania z ...(podaj strone), potem to bedzie log");
        }
    }
}
