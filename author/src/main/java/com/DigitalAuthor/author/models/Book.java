package com.DigitalAuthor.author.models;

public class Book {
	
		private int BookId;
		public Book() {
			super();
			// TODO Auto-generated constructor stub
		}
		private String title;
		private String category;
		private int price;
		private String author;
		public int getBookId() {
			return BookId;
		}
		public void setBookId(int bookId) {
			BookId = bookId;
		}
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
		public String getPublisher_date() {
			return publisher_date;
		}
		public void setPublisher_date(String publisher_date) {
			this.publisher_date = publisher_date;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getActive() {
			return active;
		}
		public void setActive(String active) {
			this.active = active;
		}
		private String publisher;
		private String publisher_date;
		private String content;
		private String active;
}
