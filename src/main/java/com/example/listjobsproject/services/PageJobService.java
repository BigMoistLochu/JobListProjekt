package com.example.listjobsproject.services;

import com.example.listjobsproject.models.PageJob;
import com.example.listjobsproject.repositories.PageJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageJobService {

    PageJobRepository pageJobRepository;

    @Autowired
    public PageJobService(PageJobRepository pageJobRepository) {
        this.pageJobRepository = pageJobRepository;
    }

    public List<PageJob> getAllPagesJob()
    {
        return pageJobRepository.findAll();
    }

    public void savePageJob(PageJob pageJob){
        pageJobRepository.save(pageJob);
    }



}
