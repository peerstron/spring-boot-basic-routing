package com.tronix.api.controller;

import com.tronix.api.dtos.ArticleDTO;
import com.tronix.api.dtos.CreateArticleRequestBody;
import com.tronix.api.model.Article;
import com.tronix.api.model.Author;
import com.tronix.api.services.ArticleService;
import com.tronix.api.services.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {

    private final ArticleService articleService;
    private final AuthorService authorService;

    public ArticleController(ArticleService articleService, AuthorService authorService) {
        this.articleService = articleService;
        this.authorService = authorService;
    }


    @GetMapping
    public List<ArticleDTO> getArticles(){
        return articleService.getArticles();
    }

    @PostMapping
    public String createArticle(CreateArticleRequestBody createArticleRequestBody){

        // Check to make sure Author exist
        Author author = authorService.getAuthorById(createArticleRequestBody.authorId());


        Article article = new Article();
        article.setTitle(createArticleRequestBody.title());
        article.setContent(createArticleRequestBody.content());
        article.setAuthor(author);
        articleService.createArticle(article);
        return article.getId();
    }

    @PostMapping("{articleId}")
    public String Poster(){
        return "Helloo Post mapping";
    }

    @GetMapping("{articleId}")
    public ArticleDTO getArticle(@PathVariable("articleId") String articleId) {
        return articleService.getArticle(articleId);
    }
}
