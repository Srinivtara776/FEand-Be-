package com.DigitalAuthor.author.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DigitalAuthor.author.models.Author;
import com.DigitalAuthor.author.models.Book;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

	Book save(Book q);

}
