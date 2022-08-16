 package com.digitalbooksreader.reader.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digitalbooksreader.reader.models.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Integer> {

	@Query("select r from Reader r where r.email= ?1")
	public List<Reader> findbyEmail(String email);
}
