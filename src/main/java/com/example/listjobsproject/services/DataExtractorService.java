package com.example.listjobsproject.services;

import com.example.listjobsproject.scrapper.ThreadState;
import com.example.listjobsproject.dataValidityVerifier.DataExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataExtractorService {

    private static DataExtractor dataExtractor;
    @Autowired
    public DataExtractorService(DataExtractor dataExtractor)
    {
        this.dataExtractor = dataExtractor;
    }

    public static void giveNotification(String threadName, ThreadState state)
    {
        dataExtractor.getNotification(threadName,state);
    }
}
