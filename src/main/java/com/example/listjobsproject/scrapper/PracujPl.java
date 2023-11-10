package com.example.listjobsproject.scrapper;


import com.example.listjobsproject.services.DataExtractorService;
import com.example.listjobsproject.dataValidityVerifier.DataValidator;
import com.example.listjobsproject.models.PageJobDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
            Document doc = Jsoup.connect("http://pracuj.com").get();
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
