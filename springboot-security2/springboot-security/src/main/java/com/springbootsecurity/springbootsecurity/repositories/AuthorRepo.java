package com.springbootsecurity.springbootsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springbootsecurity.springbootsecurity.models.Author;


@Repository
public interface AuthorRepo extends JpaRepository<Author, String> {

	@Query("select a from Author a where a.username = ?1")
	public Author findByUsername(String username);
	

}

