package com.example.listjobsproject.services;

import com.example.listjobsproject.repositories.PageJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PageJobService {

    PageJobRepository pageJobRepository;

    @Autowired
    public PageJobService(PageJobRepository pageJobRepository) {
        this.pageJobRepository = pageJobRepository;
    }
}
