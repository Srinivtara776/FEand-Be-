package com.digitalbooks.books.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.books.models.Book;
import com.digitalbooks.books.services.BookService;

@RestController
@RequestMapping("/books")
@CrossOrigin("*")
public class BookController {
	 
	@Autowired
	 private BookService service;
	@GetMapping("")
	public List<Book> getAllBooks(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Book getBook(@PathVariable int id){
		return service.findOneById(id);
	 //return "inserted book";
	 
	}
	//@KafkaListener(topics = "kafka-topic-name", groupId="group_id", containerFactory = "userKafkaListenerFactory")
	@PostMapping(" ")
	public Book saveBook(@RequestBody Book book){
		return service.createNewBook(book);
	}
	@PutMapping("/{id}")
	public Book editBook(@RequestBody Book book, @PathVariable int id){
		return service.editBook(book,id);
	
	}
	@GetMapping("/subscribeBook")
	public Book subscribeBook(@RequestParam int id) {
		return service.buyBook(id);
	}
	@GetMapping("/subscribedBook")
	public Book subscribedBook(@RequestParam int id) {
		return service.buyBook(id);
	}
//	@PostMapping("/createbook")
//	public Book createBook(@RequestBody Book book){
//		return service.createNewBook(book);
//	}
	
	
	
	@GetMapping("/category/{category}")
	public List<Book> getBookByCategory(@PathVariable String category){
		return service.findByCategory(category);
	}
	@GetMapping("/title/{title}")
	public List<Book> getBookByTitle(@PathVariable String title){
		return service.findByTitle(title);
	}
	@GetMapping("/author/{author}")
	public List<Book> getAuthor(@PathVariable String author){
		return service.findByAuthor(author);
	}
	@GetMapping("price/{price}")
	public List<Book> getPrice(@PathVariable int price){
		return service.findByPrice(price);
	}
	@GetMapping("/publisher/{publisher}")
	public List<Book> getPublisher(@PathVariable String publisher){
		return service.findByPublisher(publisher);
	}
	@GetMapping("/search/{author}/{category}/{price}/{publisher}")
	public List<Book> findBookBasedOnInput(@PathVariable String author, @PathVariable String category, @PathVariable int price, @PathVariable String publisher){
		return service.findBookBasedOnInput(author, category, price, publisher);
	}
}
