package com.tronix.api.dtos;

import com.tronix.api.model.Article;

import java.util.Set;

public record AuthorDTO (
        String id,
        String name,
        String email,
        String phone
){
}
