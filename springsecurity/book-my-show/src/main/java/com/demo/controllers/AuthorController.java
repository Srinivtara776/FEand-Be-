package com.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.clients.DigitalAuthorClient;
import com.demo.models.Author;

import com.demo.models.Show;
import com.demo.services.AuthorService;
import com.digitalbooks.books.models.Book;
//import com.demo.services.BookService;
import com.google.common.net.HttpHeaders;

//import feign.Request.HttpMethod;

@RestController
@RequestMapping("/author/api/v1")
public class AuthorController {

//@Autowired
//private RestTemplate rs;

	@Autowired
	private AuthorService service;
	
	@Autowired
	DigitalAuthorClient client;
	
	@GetMapping("/authorPage")
	public String onlyForAuthor() {
		System.out.println("only for manager");
		return "welcome author";
	}
	
	
	@PostMapping("/register")
	public Author add(@RequestBody Author a){
		return service.createAuthor(a); 
	}
	
	@GetMapping("/see")
	public List<Author> see(){
		return service.seeAuthor();
	}
//	@PostMapping("/createBook")
//	public ResponseEntity<Book> addBook(@RequestBody Book b){
//		
//		String URL = "http://localhost:9090/book/api/v1/createBook";
//		
//		return rs.postForEntity(URL, b, Book.class);
//		
//	}

    @PostMapping("/createbooks")
	public Book createBook(@RequestBody Book book) {
		return client.saveBook(book);
		
	}

	
	@GetMapping("")
	public String greet(){
		return "hello";
	}
	
	
	
}
