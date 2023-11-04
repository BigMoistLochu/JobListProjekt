package com.example.listjobsproject.api;

import com.example.listjobsproject.models.PageJob;
import com.example.listjobsproject.services.PageJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PageJobController {


    PageJobService pageJobService;

    @Autowired
    public PageJobController(PageJobService pageJobService) {
        this.pageJobService = pageJobService;
    }


    @GetMapping("/pages")
    public List<PageJob> getAllPageJobs()
    {
        return pageJobService.getAllPagesJob();
    }
}
