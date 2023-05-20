package com.tronix.api.news;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {
    @GetMapping("/news")
    public String news(){
        System.out.println("in News route...");
        return "news";
    }
}
