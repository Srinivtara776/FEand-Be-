package com.DigitalAuthor.author.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DigitalAuthor.author.models.Author;
import com.DigitalAuthor.author.models.Book;
import com.DigitalAuthor.author.repositories.AuthorClient;
import com.DigitalAuthor.author.services.AuthorService;

@RestController
@RequestMapping("/books")
public class AuthorController {
  
	@Autowired
	 AuthorService authorservice;
	@Autowired
	AuthorClient authorclient;
	@PostMapping("/{authorId}/books")
	public Book createBook(@RequestBody Author author){
		return authorclient.createNewBook(author);
	}
	@PutMapping("")
	public Book editBook(@RequestBody Author author, @PathVariable int id){
		return authorclient.editBook(author,id);
	
	}
}
