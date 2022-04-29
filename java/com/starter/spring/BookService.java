package com.example.demo.Lib;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookRepository BookRepository;
	
	public List<Book> getAllBooks(String topicId){
		
		List<Book> books=new ArrayList<>();				
		BookRepository.findByTopicId(topicId)
		.forEach(books::add);
		return books;
		
	}
	public Book getBook(String id) {
		return bookRepository.findById(id).get();
	}
	public void addBook(Book book) {
		bookRepository.save(book);
		
	}
	public void updateBook(Book book) {
		bookRepository.save(book);
				
			}		
	public void deletebook(String id) {
		bookRepository.deleteById(id);
	}

}
	
