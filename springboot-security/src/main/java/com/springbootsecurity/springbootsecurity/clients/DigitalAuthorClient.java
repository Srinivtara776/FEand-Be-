package com.springbootsecurity.springbootsecurity.clients;


//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.digitalbooks.books.models.Book;


//@FeignClient("digital-books")
public interface DigitalAuthorClient {



	
	@PostMapping("/books")
	public Book saveBook(@RequestBody Book book);
		
	

	
}
