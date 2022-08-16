package com.springbootsecurity.springbootsecurity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.springbootsecurity.springbootsecurity.models.Author;
import com.springbootsecurity.springbootsecurity.models.Book;
import com.springbootsecurity.springbootsecurity.services.AuthorService;


//import feign.Request.HttpMethod;

@RestController
@CrossOrigin("*")
@RequestMapping("/author/api/v1")
public class AuthorController {



	@Autowired
	private AuthorService service;
	@Autowired 
	private RestTemplate restTemplate;
//	@Autowired
//	private KafkaTemplate<String, Book> kafkaTemplate;
//	private static final String TOPIC = "kafka-topic-name";
	
//	@Autowired
//	DigitalAuthorClient client;
	
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
	//kafka
//	@PostMapping("/createBook")
//	public ResponseEntity<Book> createBook(@RequestBody Book b){
//		HttpHeaders headers = new HttpHeaders();
//		HttpEntity<Book> entity = new HttpEntity<Book>(b,headers);
//		String uri = "http://localhost:9090/books";
//		
//		return restTemplate.postForEntity(uri, b, Book.class);
//		
//		
//	    kafkaTemplate.send(TOPIC, b);
//		return null;
//	}

//    @PostMapping("/createbooks")
//	public Book createBook(@RequestBody Book book) {
//		return client.saveBook(book);
//		
//	}
	@PostMapping("/createBook")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
	HttpHeaders headers = new HttpHeaders();
		//HttpEntity<Book> entity = new HttpEntity<Book>(book,headers);
		HttpEntity<Book> entity = new HttpEntity<Book>(book,headers);
		String uri = "http://13.235.99.87:9090/books";
		return restTemplate.postForEntity(uri, book, Book.class);
		
	}
	@PutMapping("/modifybooks/{id}")
   	public Book modifyBook(@PathVariable int id,@RequestBody Book book) {
   	HttpHeaders headers = new HttpHeaders();
  		//HttpEntity entity = new HttpEntity(book,headers);
   	   HttpEntity<Book> entity = new HttpEntity<Book>(book,headers);
   		String uri = "http://13.235.99.87:9090/books/"+id;
  		return restTemplate.exchange(
  			uri, HttpMethod.PUT, entity, Book.class).getBody();
  		}
   		}
   		
  	
	
	
	
	
	

