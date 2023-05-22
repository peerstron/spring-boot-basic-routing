package com.tronix.api.services;

import com.tronix.api.model.Author;

import java.util.List;

// Interface is used here in order to prevent tight coupling. Implementation classes are in implementations package
public interface AuthorService {

    // Get all Authors
    List<Author> getAllAuthors();
}
