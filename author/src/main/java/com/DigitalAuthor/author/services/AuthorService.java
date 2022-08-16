package com.DigitalAuthor.author.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DigitalAuthor.author.models.Author;
import com.DigitalAuthor.author.models.Book;
import com.DigitalAuthor.author.repositories.AuthorClient;
import com.DigitalAuthor.author.repositories.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository repo;
	@Autowired
	AuthorClient authorclient;
//  public Book createBook(Book b) {
//	}
//
//	public Book editBook(Book b,int id) {
//		Book q = repo.findById(id).get();
//		q.setTitle(b.getTitle());
//		q.setCategory(b.getCategory());
//		q.setAuthor(b.getAuthor());
//		q.setPublisher(b.getPublisher());
//		q.setContent(b.getContent());
//		q.setActive(b.getActive());
//		q.setPublishe//	return authorclient.save(b);
//	r(b.getPublisher());
//        q.setPrice(b.getPrice());
//		return repo.save(q);
//		
//		
//	}
//	
}
