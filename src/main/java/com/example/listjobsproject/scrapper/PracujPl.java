package com.example.listjobsproject.scrapper;

public class PracujPl implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("To jest klasa: "+getClass()+" a watek: "+Thread.currentThread().getId()+" a liczba to: "+i);
        }
    }
}
