package com.tronix.api.controller;

import com.tronix.api.model.Author;
import com.tronix.api.services.AuthorService;
import com.tronix.api.services.implementations.AuthorServiceImplementation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // This annotation makes this a Spring MVC class in order to handle requests
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
    @GetMapping("/api/v1/authors")
    public List<Author> listAuthors1(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/authors/new")
    public String newAuthorForm(Model model){

        // We create an object to hold the data coming from the form
        Author author = new Author();
        model.addAttribute("author", author);
        return "/pages/newAuthorForm";
    }

    // Method to handle form submission from client
    @PostMapping("/authors")
    public String handleNewAuthorFormSubmission(@ModelAttribute("author") Author author){
        authorService.saveAuthor(author);

        return "redirect:/authors";
    }


    // Handle Update request
    @GetMapping("/authors/update/{id}")
    public String updateAuthorForm(@PathVariable String id, Model model){

        model.addAttribute("author", authorService.getAuthorById(id));
        return "/pages/updateAuthorForm";
    }

    // Method to Respond to Update Author Request from client
    @PostMapping("/authors/{id}")
    public String updateAuthorRequestResponseHandler(
            @PathVariable String id,
            @ModelAttribute("author") Author author,
            Model model){

        // Get Author from db by the id
        Author authorInDb = authorService.getAuthorById(id);

        // Update found author's data
        authorInDb.setId(id);
        authorInDb.setName(author.getName());
        authorInDb.setPhone(author.getPhone());
        authorInDb.setEmail(author.getEmail());

        // Save updated author
        authorService.updateAuthor(authorInDb);

        // Redirect to authors page or wherever you like
        return "redirect:/authors";
    }

    // Delete request
    @GetMapping("authors/{id}")
    public String deleteAuthorRequest(@PathVariable String id){
        authorService.deleteAuthorById(id);
        return "redirect:/authors";
    }
}
