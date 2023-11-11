package com.example.listjobsproject.scrapper;


import com.example.listjobsproject.services.DataExtractorService;
import com.example.listjobsproject.dataValidityVerifier.DataValidator;
import com.example.listjobsproject.models.PageJobDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class PracujPl implements Runnable, EventListener {


    DataValidator dataValidator;
    private static final Logger logger = LogManager.getLogger(PracujPl.class);
    public PracujPl(DataValidator dataValidator) {
        this.dataValidator = dataValidator;
    }

    @Override
    public void run() {

        try
        {
            Document doc = Jsoup.connect("https://it.pracuj.pl/praca/java;kw?et=1%2C17&itth=38").get();

            String company = doc.select(".core_c1sbal7t > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > a:nth-child(1) > h4:nth-child(1)").text();
            System.out.println(company);
            String href = doc.select(".core_c1sbal7t > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)").attr("href");
            System.out.println(href);
            String title = doc.select(".core_c1sbal7t > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > h2:nth-child(2) > a:nth-child(1)").text();
            String title2 = doc.select(".core_c1sbal7t > div:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > h2:nth-child(1)").text();
            String title3 = doc.select(".core_c1sbal7t > div:nth-child(3) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > h2:nth-child(3) > a:nth-child(1)").text();
            System.out.println(title);



            List<PageJobDto> listOfNoobs = new ArrayList<>(List.of(new PageJobDto("pracuje0","xd2",new BigDecimal("4334"),"xd3"),
                new PageJobDto("pracuje1","xd2",new BigDecimal("4334"),"xd3"),
                new PageJobDto("pracuje2","xd2",new BigDecimal("4334"),"xd3"),
                new PageJobDto("pracuje3","xd2",new BigDecimal("4334"),"xd3"),
                new PageJobDto("pracuje4","xd2",new BigDecimal("4334"),"xd3")
            ));

            listOfNoobs.stream().forEach(
                noob -> dataValidator.Validate(noob.getTitle()
                        ,noob.getUrl()
                        ,noob.getCompany(),"4323")
            );

        }
        catch(IOException e){
            logger.error(e);
        }
        finally {
            logger.info("Klasa: "+PracujPl.class+" Skonczyla prace!");
            threadEndOfWork(this.getClass().getSimpleName(),ThreadState.DONE);
        }
    }

    @Override
    public void threadEndOfWork(String threadName, ThreadState state) {
        DataExtractorService.giveNotification(threadName,state);
    }
}
