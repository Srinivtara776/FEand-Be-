package com.DigitalAuthor.author.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authorid;
	private String username;
	private String password;
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Author(int authorid, String username, String password) {
		super();
		this.authorid = authorid;
		this.username = username;
		this.password = password;
	}
	
	
	
	

}
