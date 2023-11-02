package com.example.listjobsproject.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPage {



    @GetMapping("/")
    public String getMainPage()
    {
        return "index.html";
    }
}
