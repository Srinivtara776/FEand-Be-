package com.demo.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.models.Show;
import com.digitalbooks.books.models.Book;

//@FeignClient(value = "comic", url = "http://localhost:8082/api/v1")
@FeignClient("superhero-movies")
public interface DigitalAuthorClient {

	@GetMapping("/superheros/movies")
    List<Show> getMovies();
	
	@PostMapping("/books")
	public Book saveBook(@RequestBody Book book);
		
	
//    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json")
//    Post getPostById(@PathVariable("postId") Long postId);
	
}
