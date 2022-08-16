package com.digitalbooksreader.reader.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.*;
@Getter
@Setter
@Entity
@Table
public class Reader {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	private int buyid;
     private String name;
     private String email;
	public Reader() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reader(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBuyid() {
		return buyid;
	}
	public void setBuyid(int buyid) {
		this.buyid = buyid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
