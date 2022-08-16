package com.digitalbooks.books.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digitalbooks.books.models.Book;


public interface BookRepository extends JpaRepository<Book,Integer>{

	@Query("select b from Book b where b.author= ?1 and b.active = '1'")
	public List<Book> findByAuthor(String author);
	
	@Query("select b from Book b where b.category= ?1 and b.active = '1'")
    public List<Book> findByCategory(String category);
	
	@Query("select b from Book b where b.price= ?1 and b.active = '1'")
	public List<Book> findByPrice(int price);
	
	@Query("select b from Book b where b.publisher= ?1 and b.active = '1'")
	public List<Book> findByPublisher(String publisher);
	
	@Query("select b from Book b where b.author=?1 and b.category=?2 and b.price=?3 and b.publisher=?4")
	public List<Book> findBookBasedOnInput(String author, String category, int price, String publisher);
    
	@Query("select b from Book b where b.title= ?1 and b.active = '1'")
	public List<Book> findByTitle(String title);
	
	@Query("select b from Book b where b.id= ?1")
	public Book findBookById(int id);
}
