package com.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

@Entity
public class Author {
	
    @Id
	private String username;
	private String password;
	
	@Override
	public String toString() {
		return "Author [username=" + username + ", password=" + password + "]";
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
	public Author(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Author() {
		super();
	}
	
	
	
	

}
