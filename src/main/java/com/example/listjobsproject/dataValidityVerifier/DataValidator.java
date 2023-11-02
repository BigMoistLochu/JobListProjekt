package com.example.listjobsproject.dataValidityVerifier;

import com.example.listjobsproject.models.PageJobDto;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;

@Component
public final class DataValidator {



    public void Validate(String title, String url, String company, String salary)
    {
        if(isValidStrings(title,url,company,salary) && isValidSalary(salary))
        {
            //obiekt gotowy do obslugi
          PageJobDto a  = pageMapper(title,url,company,new BigDecimal(salary));
        }
    }


    private boolean isValidStrings(String... argumenty)
    {
        for (String arg : argumenty) {
            if(arg == null || arg.isBlank() || arg.isEmpty())
                return false;
        }
        return true;
    }


    private boolean isValidSalary(String salary)
    {
        return NumberUtils.isCreatable(salary);
    }


    private PageJobDto pageMapper(String title, String url, String company, BigDecimal salary)
    {
        return new PageJobDto.PageScrapperBuilder()
                .title(title)
                .url(url)
                .company(company)
                .salary(salary)
                .build();
    }

}
