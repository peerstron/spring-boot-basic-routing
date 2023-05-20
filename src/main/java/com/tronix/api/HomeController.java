package com.tronix.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// This is a web controller, and it tells the Spring MVC to map certain web-calls to this controller.
// Methods that a defined in this class handle web-calls directed to this controller class.
@Controller
public class HomeController {


    @GetMapping("/")    // This handles all GET calls directed to the "/" route
    public String home(){
        System.out.println("in Home route...");
        return "home";
    }
}
