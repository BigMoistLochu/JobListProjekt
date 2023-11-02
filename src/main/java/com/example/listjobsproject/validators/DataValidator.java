package com.example.listjobsproject.validators;

import com.example.listjobsproject.models.PageScrapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataValidator {




    public void Validate(String title, String url, String company, String salary)
    {
        if(isValidStrings(title,url,company,salary) && isValidSalary(salary))
        {
          PageScrapper a  = pageMapper(title,url,company,new BigDecimal(salary));
            System.out.println(a.toString());
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
    {
        try {
            BigDecimal bigDecimal = new BigDecimal(salary);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
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
