package com.digitalbooks.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.books.models.Book;
import com.digitalbooks.books.repositories.BookRepository;
@Service
public class BookService {
	
	@Autowired
	private BookRepository repo;

	
	
	public Book findOneById(int id) {
		Optional<Book> optional = repo.findById(id);
		if(optional.isEmpty()) {
			throw new RuntimeException("Could not find book with id: "+id);
		} else {
			return optional.get();
		}
	}
	
	public Book createNewBook(Book b) {
		return repo.save(b);
	}

	public Book editBook(Book b,int id) {
		Book b1 = repo.findById(id).get();
		b1.setTitle(b.getTitle());
		b1.setCategory(b.getCategory());
	    b1.setAuthor(b.getAuthor());
	    b1.setPrice(b.getPrice());
		b1.setPublisher(b.getPublisher());
		b1.setContent(b.getContent());
		b1.setPublisher_date(b.getPublisher_date());
		b1.setActive(b.isActive());
		b1.setPublisher(b.getPublisher());


		b1.setPrice(b.getPrice());
		return repo.save(b1);
		
		
	}

	public List<Book> findAll() {
		return repo.findAll();
	}

	public Book buyBook(int id) {
		// TODO Auto-generated method stub
		return repo.findBookById(id);
	}
	public List<Book> findByCategory(String category) {
		return repo.findByCategory(category);
	}

	public  List<Book> findByAuthor(String author) {
		return repo.findByAuthor(author);
	}


	public List<Book> findByPublisher(String publisher) {
		return repo.findByPublisher(publisher);
	}

	public List<Book> findByPrice(int price) {
		return repo.findByPrice(price);
	}
	
	public List<Book> findBookBasedOnInput(String author, String category, int price, String publisher){
		return repo.findBookBasedOnInput(author, category, price, publisher);
	}

	public List<Book> findByTitle(String title) {
		return repo.findByTitle(title);
	}
}
