package com.example.listjobsproject.scrapper;

import com.example.listjobsproject.NewFiczer.EventListener;
import com.example.listjobsproject.NewFiczer.DataExtractorService;
import com.example.listjobsproject.dataValidityVerifier.DataValidator;
import com.example.listjobsproject.models.PageJobDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class NoFluffJobs implements Runnable, EventListener {


    private final String URL = "https://nofluffjobs.com/pl/Java?page=1&criteria=seniority%3Djunior";

    DataValidator dataValidator;


    public NoFluffJobs(DataValidator dataValidator) {
        this.dataValidator = dataValidator;
    }

    @Override
    public void run() {

        try
        {
            Document doc = Jsoup.connect(URL).get();
            String s = doc.select("#nfjPostingListItem-junior-java-developer-bersi-Bydgoszczds").attr("href");

            List<PageJobDto> listOfNoobs = new ArrayList<>(List.of(new PageJobDto("nofluff0","xd2",new BigDecimal("4334"),"xd3"),
                    new PageJobDto("nofluff1","xd2",new BigDecimal("4334"),"xd3"),
                    new PageJobDto("nofluff2","xd2",new BigDecimal("4334"),"xd3"),
                    new PageJobDto("nofluf3","xd2",new BigDecimal("4334"),"xd3"),
                    new PageJobDto("nofluff4","xd2",new BigDecimal("4334"),"xd3")
            ));

            listOfNoobs.stream().forEach(
                    noob -> dataValidator.Validate(noob.getTitle()
                            ,noob.getUrl()
                            ,noob.getCompany(),"4323")
            );


            //jesli skonczy robote poinformuj klase o skonczeniu ale jak?

        }
        catch(IOException e){
            System.out.println("blad sciagania z ...(podaj strone), potem to bedzie log");
        }
        finally {
            System.out.println("Watek wywoluje metode endOfWork");
            threadEndOfWork();
        }

    }

    @Override
    public void threadEndOfWork() {
        DataExtractorService.giveNotification(getClass().getName(),true);
    }
}
