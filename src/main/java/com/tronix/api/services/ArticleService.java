package com.tronix.api.services;

import com.tronix.api.dtos.ArticleDTO;
import com.tronix.api.model.Article;

import java.util.List;

public interface ArticleService {

    String createArticle(Article article);
    List<ArticleDTO> getArticles();
    ArticleDTO getArticle(String id);
}
