package com.example.listjobsproject.dataValidityVerifier;

import com.example.listjobsproject.NewFiczer.ThreadState;
import com.example.listjobsproject.models.PageJob;
import com.example.listjobsproject.models.PageJobDto;
import com.example.listjobsproject.services.PageJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public final class DataExtractor {

    //klasa ktora bedzie posredniczyc z baza danych, czyli PageJobService PageJobRepository
    //lista obiektow ktor
    private final List<PageJobDto> pageJobDtoList = new ArrayList<>();
    private final Map<String,ThreadState> mapOfThreads = new HashMap<>();

    private int NUMBER_OF_THREAD = 0;

    private PageJobService pageJobService;

    @Autowired
    public DataExtractor(PageJobService pageJobService) {
        this.pageJobService = pageJobService;
    }

    public void addToTheList(PageJobDto dto)
    {
        pageJobDtoList.add(dto);
    }

    public void getNotification(String threadName,ThreadState state)
    {
        mapOfThreads.put(threadName,state);
        NUMBER_OF_THREAD+=1;
        if(NUMBER_OF_THREAD==2)
        {
            ifAllThreadsDonePutToDataBaseAllEntity();
        }
    }

    private void ifAllThreadsDonePutToDataBaseAllEntity()
    {
        if(checkAllStateIsTrue())
        {
            pageJobDtoList.stream().map(pageJobDto -> new PageJob(
                    pageJobDto.getTitle()
                    ,pageJobDto.getUrl(),
                    pageJobDto.getSalary()
                    ,pageJobDto.getCompany()
            ))
                    .forEach(pageJob -> pageJobService.savePageJob(pageJob));
        }
    }

    private boolean checkAllStateIsTrue()
    {
        return !mapOfThreads.containsKey(ThreadState.UNDONE);
    }
}
