package com.example.listjobsproject.dataValidityVerifier;

import com.example.listjobsproject.models.PageJobDto;
import com.example.listjobsproject.services.PageJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataExtractor {

    //klasa ktora bedzie posredniczyc z baza danych, czyli PageJobService PageJobRepository
    //lista obiektow ktor
    private final List<PageJobDto> pageJobDtoList = new ArrayList<>();
    private final Map<String,Boolean> mapOfThreads = new HashMap<>();

    private PageJobService pageJobService;

    @Autowired
    public DataExtractor(PageJobService pageJobService) {
        this.pageJobService = pageJobService;
    }

    public void addToTheList(PageJobDto dto)
    {
        pageJobDtoList.add(dto);
    }

    public void getNotification(String threadName,boolean state)
    {
        mapOfThreads.put(threadName,state);
    }

    public void dodajDoBazyJesliWszystkieWatkiSkonczylyPrace()
    {

    }
}
