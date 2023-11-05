package com.example.listjobsproject.scrapper;


import com.example.listjobsproject.dataValidityVerifier.DataValidator;
import com.example.listjobsproject.models.PageJobDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PracujPl implements Runnable{


    DataValidator dataValidator;

    public PracujPl(DataValidator dataValidator) {
        this.dataValidator = dataValidator;
    }

    @Override
    public void run() {

//        try
//        {
//            Document doc = Jsoup.connect("http://pracuj.com").get();
//
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


//
//        }
//        catch(IOException e){
//            System.out.println("blad sciagania z ...(podaj strone), potem to bedzie log");
//        }
    }
}
