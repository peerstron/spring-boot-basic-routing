package com.tronix.api.dtos;

import com.tronix.api.model.Author;

public record ArticleDTO (
        String id,
        String title,
        String content,
        Author author
){
}
