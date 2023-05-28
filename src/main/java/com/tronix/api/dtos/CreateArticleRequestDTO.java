package com.tronix.api.dtos;

public record CreateArticleRequestDTO(
        String title,
        String content,
        String authorId
) {
}
