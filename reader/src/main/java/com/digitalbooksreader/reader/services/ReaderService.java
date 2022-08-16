package com.digitalbooksreader.reader.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooksreader.reader.models.Book;
import com.digitalbooksreader.reader.models.Reader;
import com.digitalbooksreader.reader.models.Subscription;
import com.digitalbooksreader.reader.repository.ReaderClient;
import com.digitalbooksreader.reader.repository.ReaderRepository;
//import com.digitalbooksreader.reader.repository.SubscriptionRepo;




@Service
public class ReaderService {
	@Autowired
	ReaderClient client;
	@Autowired
	ReaderRepository repo;
	
//	@Autowired
//	SubscriptionRepo srepo;
//	
	public List<Book> getAllBooks(){
		return client.getAllBooks();
	}
	
	public List<Book> findBookBasedOnInput(String author, String category, int price, String publisher){
		return client.findBookBasedOnInput(author, category, price, publisher);
	}
	public Reader saveOrUpdate(Reader reader) {
		return repo.save(reader);
	}
	
//	public SubscriptionRepo saveOrUpdateSub(Subscription books) {
//	return srepo.save(books);
//	}

	
	
}
	
	

	
	
	
	
	

