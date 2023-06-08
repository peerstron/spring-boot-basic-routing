package com.tronix.api.dtos;

public record CreateArticleRequestBody(
        String title,
        String content,
        String authorId
) {
}
