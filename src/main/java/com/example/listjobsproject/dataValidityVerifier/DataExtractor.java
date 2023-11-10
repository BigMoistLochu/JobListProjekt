package com.example.listjobsproject.dataValidityVerifier;

import com.example.listjobsproject.scrapper.ThreadState;
import com.example.listjobsproject.models.PageJob;
import com.example.listjobsproject.models.PageJobDto;
import com.example.listjobsproject.services.PageJobService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
    private static final Logger logger = LogManager.getLogger(DataExtractor.class);

    @Autowired
    public DataExtractor(PageJobService pageJobService) {
        this.pageJobService = pageJobService;
    }

    public synchronized void addJobDtoToTheList(PageJobDto pageJobDtodto)
    {
        pageJobDtoList.add(pageJobDtodto);
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
           List<PageJob> pageJobList =  pageJobDtoList.stream().map(pageJobDto -> new PageJob(
                    pageJobDto.getTitle()
                    ,pageJobDto.getUrl(),
                    pageJobDto.getSalary()
                    ,pageJobDto.getCompany()
            )).toList();
           pageJobService.saveAllPageJob(pageJobList);
           logger.info("List Of All Object from DataExtractor was dropped into a DataBase!");
        }
    }

    private boolean checkAllStateIsTrue()
    {
        return !mapOfThreads.containsKey(ThreadState.UNDONE);
    }
}
