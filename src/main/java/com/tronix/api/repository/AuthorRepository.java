package com.tronix.api.repository;

import com.tronix.api.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Here because we are working with JPA we don't need to create a class but rather we need an Interface
// and then extend the JpaRepository. I am using this because it comes with ready to use methods that I need
public interface AuthorRepository extends JpaRepository<Author, String> {
}
