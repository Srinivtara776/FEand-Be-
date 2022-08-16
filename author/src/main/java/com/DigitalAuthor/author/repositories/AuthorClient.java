package com.DigitalAuthor.author.repositories;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.DigitalAuthor.author.models.Author;
import com.DigitalAuthor.author.models.Book;

@FeignClient(name = "BookService",url = "http://localhost:8081")
public interface AuthorClient {
	@PostMapping("/books")
	public Book createNewBook(@RequestBody Author author);
	@PutMapping("/books/{id}")
	public Book editBook(@RequestBody Author author, @PathVariable int id);

}
