package com.tronix.api.controller;

import com.tronix.api.dtos.ArticleDTO;
import com.tronix.api.dtos.CreateArticleRequestDTO;
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
    public String createArticle(CreateArticleRequestDTO createArticleRequestDTO){
        Author author = authorService.getAuthorById(createArticleRequestDTO.authorId());
        Article article = new Article();
        article.setTitle(createArticleRequestDTO.title());
        article.setContent(createArticleRequestDTO.content());
        article.setAuthor(author);
        articleService.createArticle(article);
        return article.getId();
    }

    @GetMapping("{articleId}")
    public ArticleDTO getArticle(@PathVariable("articleId") String articleId) {
        return articleService.getArticle(articleId);
    }
}
