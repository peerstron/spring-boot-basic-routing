package com.tronix.api.services.implementations;

import com.tronix.api.model.Author;
import com.tronix.api.repository.AuthorRepository;
import com.tronix.api.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImplementation implements AuthorService {

    // Inject dependency
    private final AuthorRepository authorRepository;

    // Constructor

    public AuthorServiceImplementation(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {

        // TODO: I will customize this query in order to limit the number of records i will be getting from the db.
        //  Limiting the number of records returned here helps prevent the Java Heap Space OutOfMemory bug
        return authorRepository.findAll();
    }
}
