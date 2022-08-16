package com.digitalbooksreader.reader.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digitalbooksreader.reader.models.Subscription;

public interface SubscriptionRepo1 extends JpaRepository<Subscription, Integer>{
	
	
	
	@Query("select r from Subscription r where r.readerEmail = ?1")
	List<Subscription> findByReaderEmail(String readerEmail);
	
	
	@Query("select r from Subscription r where r.book_id=?1 and r.readerEmail = ?2")
	public Subscription findByPayIdReaderEmail(int bookId, String readerEmail);
	
	@Query("select r from Subscription r where r.book_id = ?1 and r.readerEmail = ?2")
	public Subscription findByBookIdandReaderEmail(int bookId, String readerEmail);


	
			
	
	
	
	
			
	

}
