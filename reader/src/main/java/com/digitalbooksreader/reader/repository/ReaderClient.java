package com.digitalbooksreader.reader.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.digitalbooksreader.reader.models.Book;


@FeignClient(name ="DIGITAL-BOOKS")
public interface ReaderClient {
	@GetMapping("/books")
	public List<Book> getAllBooks();
	@GetMapping("/books/{id}")
	public String getBook(@PathVariable int id);
	@GetMapping("books/subscribeBook")
	public Book subscribeBook(@RequestParam int id);
	@GetMapping("books/subscribedBook")
	public Book subscribedBook(@RequestParam int id);
	
	@GetMapping("/books/publisher/{publisher}")
	public List<Book> getPublisher(@PathVariable String publisher);
	@GetMapping("/books/author/{author}")
	public List<Book> getAuthor(@PathVariable String author);
	@GetMapping("/books/category/{category}")
	public List<Book> getBookByCategory(@PathVariable String category);
	@GetMapping("/books/title/{title}")
	public List<Book> getBookByTitle(@PathVariable String title);
	@GetMapping("/books/price/{price}")
	public List<Book> getPrice(@PathVariable int price);
	@GetMapping("/books/search/{author}/{category}/{price}/{publisher}")
	public List<Book> findBookBasedOnInput(@PathVariable String author, @PathVariable String category, @PathVariable int price, @PathVariable String publisher);
	
	

}
