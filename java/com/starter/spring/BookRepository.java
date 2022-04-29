package com.example.demo.Lib;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String>  {
	
public List<Book> findByTopicId(String topicId);

}