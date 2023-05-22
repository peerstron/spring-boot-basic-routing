package com.tronix.api.controller;

import com.tronix.api.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // This annotation makes this a Spring MVC class in order to handle requests
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // This handler handles list Authors request and return model and view to client
    @GetMapping("/authors")
    public String listAuthors(Model model){
        model.addAttribute("authors", authorService.getAllAuthors());

        // Return view
        return "/pages/authors";
    }
}
