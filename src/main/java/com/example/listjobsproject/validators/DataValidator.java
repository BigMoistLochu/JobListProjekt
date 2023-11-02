package com.example.listjobsproject.validators;

import com.example.listjobsproject.models.PageScrapper;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;

@Component
public class DataValidator {




    public void Validate(String title, String url, String company, String salary)
    {
        if(isValidStrings(title,url,company,salary) && isValidSalary(salary))
        {
            //obiekt gotowy do obslugi
          PageScrapper a  = pageMapper(title,url,company,new BigDecimal(salary));
        }
    }


    private boolean isValidStrings(String... argumenty)
    {
        for (String arg : argumenty) {
            if(arg == null || arg.isBlank() || arg.isEmpty()){
                return false;
            }
        }
        return true;
    }


    private boolean isValidSalary(String salary)
    {   //zewnetrzna bibloteka do sprawdzenia czy mozna z tego stringa stworzyc liczbe
        return NumberUtils.isCreatable(salary);
    }


    private PageScrapper pageMapper(String title, String url, String company, BigDecimal salary)
    {
        return new PageScrapper.PageScrapperBuilder()
                .title(title)
                .url(url)
                .company(company)
                .salary(salary)
                .build();
    }

}
