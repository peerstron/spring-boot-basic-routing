package com.tronix.api.services.implementations;

import com.tronix.api.DTOMappers.ArticleDTOMapper;
import com.tronix.api.dtos.ArticleDTO;
import com.tronix.api.model.Article;
import com.tronix.api.repository.ArticleRepository;
import com.tronix.api.services.ArticleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImplementation implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleDTOMapper articleDTOMapper;

    public ArticleServiceImplementation(ArticleRepository articleRepository, ArticleDTOMapper articleDTOMapper) {
        this.articleRepository = articleRepository;
        this.articleDTOMapper = articleDTOMapper;
    }

    @Override
    public String createArticle(Article article) {
        Article art = articleRepository.save(article);
        return art.getId();
    }

    @Override
    public List<ArticleDTO> getArticles() {
        return articleRepository.findAll()
                .stream().map(articleDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public ArticleDTO getArticle(String id) {
        return articleRepository.findById(id)
                .map(articleDTOMapper)
                .orElseThrow();
    }
}
