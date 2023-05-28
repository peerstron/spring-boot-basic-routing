package com.tronix.api.DTOMappers;

import com.tronix.api.dtos.ArticleDTO;
import com.tronix.api.model.Article;
import org.springframework.stereotype.Service;
import java.util.function.Function;

@Service
public class ArticleDTOMapper implements Function<Article, ArticleDTO> {
    @Override
    public ArticleDTO apply(Article article) {
        return new ArticleDTO(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                article.getAuthor()
        );
    }
}
