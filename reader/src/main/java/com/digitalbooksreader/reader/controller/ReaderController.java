package com.digitalbooksreader.reader.controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooksreader.reader.models.Book;
import com.digitalbooksreader.reader.models.Subscription;
import com.digitalbooksreader.reader.repository.ReaderClient;
import com.digitalbooksreader.reader.repository.SubscriptionRepo1;

import com.digitalbooksreader.reader.services.ReaderService;

@RestController
@RequestMapping("/api/v1/digitalbooks/")
@CrossOrigin("*")
public class ReaderController {

	@Autowired
	ReaderService service;
	
	@Autowired
	ReaderClient client;
	
	@Autowired
	SubscriptionRepo1 srepo1;
	
	
	
//	@GetMapping("/books")
//	public List<Book> getAllBooks(){
//		return readerservice.getAllBooks();
//	}
//	
//	@GetMapping("/books/search/{author}/{category}/{price}/{publisher}")
//	public List<Book> findBookBasedOnInput(@PathVariable String author, @PathVariable String category, @PathVariable int price, @PathVariable String publisher){
//		return readerservice.findBookBasedOnInput(author, category, price, publisher);
//	}
//	@PostMapping("/save/subscribebooks")
//	public Subscriptionbook subscribeToABook(@RequestBody Subscriptionbook paybook) {
//		Book auth = client.getBookByTitle(paybook.getTitle());
//		System.out.println(auth);
//		if (auth.getTitle() == paybook.getTitle())
//		paybook.setContent(auth.getContent());
//		paybook.setEmail(auth.getEmail());
//		paybook.setAuthor(auth.getAuthor());
//		paybook.setCategory(auth.getCategory());
//		paybook.setPublisher(auth.getPublisher());
//		paybook.setPublisher_date(auth.getPublisher_date());
//		paybook.setPrice(auth.getPrice());
//		paybook.setTitle(auth.getTitle());
//		paybook.setActive(auth.getActive());
//		return service.saveOrUpdateSub(paybook);
//
//	}
//
//	
//	
//	@GetMapping("/subscribedbooks")
//	public Subscriptionbook getSubscriptionBooksByEmail(@RequestParam(name = "email") String email) {
//		return service.getBookByEmail(email);
//	}
//	
//	@GetMapping("/subscribedbooks/byid")
//	public Subscriptionbook getSubscriptionBooksById(@RequestParam(name="id") int id) {
//		return service.getBookById(id);
    @GetMapping("/subscribe/{readerName}/{readerEmail}/{book_id}")
	public Subscription subscribe(@PathVariable(value="readerName") String readerName,@PathVariable(value="readerEmail") String readerEmail,
			@PathVariable(value="book_id") int book_id) {
				Subscription sub = new Subscription();
				sub.setReaderName(readerName);
				sub.setReaderEmail(readerEmail);
				sub.setPaytime(LocalDateTime.now());
				Book book= client.subscribeBook(book_id);
				if(book!=null) {
					sub.setBook_id(book_id);
					srepo1.save(sub);
					return sub;
				}
				return null;
	}
	
	@GetMapping("/subscribedBook/{readerEmail}")
	public List<Book> getSubscribedBooks(@PathVariable(value="readerEmail") String readerEmail){
		List<Book> bookList = new ArrayList<>();
		List<Subscription> list=srepo1.findByReaderEmail(readerEmail);
		for(Subscription sub:list) {
			Book book = client.subscribedBook(sub.getBook_id());
			bookList.add(book);
		}
		if(bookList!=null) {
			return bookList;
		}
		else
		
			return null;
		
		}
		
	@DeleteMapping("/deleteBookBySubIdAndEmail/{bookId}/{readerEmail}")
	public Subscription deleteBookBySubscriptionIdAndEmail(@PathVariable int bookId,@PathVariable String readerEmail) {
		Subscription sub = srepo1.findByPayIdReaderEmail(bookId,readerEmail);
		System.out.println(sub);
		if(sub!=null) {
			long hours=ChronoUnit.HOURS.between(sub.getPaytime(), LocalDateTime.now());
			System.out.println(hours);
			if(hours<24) {
				srepo1.deleteById(sub.getPay_id());
				return sub;
			}
		}
		return null;
	}
	
	@GetMapping("/category/{category}")
	public List<Book> getBookByCategory(@PathVariable String category){
		return client.getBookByCategory(category);
	}
	@GetMapping("/title/{title}")
	public List<Book> getBookByTitle(@PathVariable String title){
		return client.getBookByTitle(title);
	}
	@GetMapping("/author/{author}")
	public List<Book> getAuthor(@PathVariable String author){
		return client.getAuthor(author);
	}
	@GetMapping("/price/{price}")
	public List<Book> getPrice(@PathVariable int price){
		return client.getPrice(price);
	}
	@GetMapping("/publisher/{publisher}")
	public List<Book> getPublisher(@PathVariable String publisher){
		return client.getPublisher(publisher);
	}
} 
