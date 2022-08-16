package com.springbootsecurity.springbootsecurity.models;


import java.util.Locale;

import javax.persistence.*;

@Entity
@Table
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int book_id;
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	private String title;
	private String category;
	private int price;
	private String author;
	private String publisher;
	private Locale publisher_date;
	private String content;
	private boolean active=true;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Locale getPublisher_date() {
		return publisher_date;
	}
	public void setPublisher_date(Locale publisher_date) {
		this.publisher_date = publisher_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Book(int book_id, String title, String category, int price, String author, String publisher,
			Locale publisher_date, String content, boolean active) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.category = category;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.publisher_date = publisher_date;
		this.content = content;
		this.active = active;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	}
	