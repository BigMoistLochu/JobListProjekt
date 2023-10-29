package com.example.listjobsproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Mvc {



    @GetMapping("/")
    public String getMainPage()
    {
        return "index.html";
    }
}
