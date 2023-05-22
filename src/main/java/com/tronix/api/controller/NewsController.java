package com.tronix.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsController {

//    @GetMapping("/news")
//    public ModelAndView news(@RequestParam("title") String title){
//        // This helps us to send both data and the view name
//        ModelAndView mv = new ModelAndView();
//
//        mv.addObject("title", title);
//        mv.setViewName("/pages/news");
//
//        System.out.println("in News route...");
//        return mv;
//    }

    @GetMapping("/news")
    public String listNews(Model model){

        // Return view
        return "/pages/news";
    }
}
