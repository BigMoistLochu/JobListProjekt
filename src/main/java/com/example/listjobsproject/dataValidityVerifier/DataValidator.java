package com.example.listjobsproject.dataValidityVerifier;

import com.example.listjobsproject.models.PageJobDto;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;

@Component
public final class DataValidator {


    DataExtractor dataExtractor;

    @Autowired
    public DataValidator(DataExtractor dataExtractor) {
        this.dataExtractor = dataExtractor;
    }

    public void Validate(String title, String url, String company, String salary)
    {
        if(isValidStrings(title,url,company,salary) && isValidSalary(salary))
        {
          PageJobDto a  = pageMapper(title,url,company,new BigDecimal(salary));
          dataExtractor.addJobDtoToTheList(a);
        }
    }

    /**
     * check all argumensts(title,url,company) is not blank,null or empty
     * @param argumenty
     * @return true if everythink is okey, false is not
     */
    private boolean isValidStrings(String... argumenty)
    {
        for (String arg : argumenty) {
            if(arg == null || arg.isBlank() || arg.isEmpty())
                return false;
        }
        return true;
    }

    /**
     * Check salary is creatable
     * @param salary
     * @return if variable salary is Creatable then return true else false
     */
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
