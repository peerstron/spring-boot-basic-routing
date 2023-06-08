package com.tronix.api.dtos;

public record UpdateArticleRequestBody(
        String title,
        String content
) {
}
