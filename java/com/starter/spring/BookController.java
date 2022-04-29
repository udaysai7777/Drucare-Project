package com.example.demo.Lib;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	@Autowired
	private BookService booksservice;
	@RequestMapping("/topics/{id}/Books")
	public List<Book> getAllbooks(@PathVariable String id) {
	return BookService.getAllBooks(id);
			}
	@RequestMapping("/topics/{topicId}/Books/{id}")
	public Book getBook(@PathVariable String id) {
		return BookService.getBook(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/Books")
	public void addTopic(@RequestBody Book book,@PathVariable String topicId)
	{
		book.setTopic(new Topic(topicId,"","",""));
		booksservice.addBook(book);
		
	}
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/books/{id}")
	public void updateBook(@RequestBody Book book,@PathVariable String topicId,@PathVariable String id) 
	{
		book.setTopic(new Topic(topicId,"","",""));
		booksservice.updateBook(book);
		
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicId},Book/{id}")
	public void deleteBook(@PathVariable String id) {
		booksservice.deletebook(id);
		
	}
}

