package com.example.demo.Lib;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.starter.spring.topic.Topic;

@Entity
public class Book {
	@Id
private String id;
private String name;
private String author;
private String year;
@ManyToOne
private Topic topic;
public Book()
{
	}
public Book(String id, String name, String author,String year,String topicId) {
	super();
	this.id =id;
	this.name = name;
	this.author=author;
	this.year=year;
	this.topic=new Topic(topicId," "," ");
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getauthor() {
	return author;
}
public void setauthor(String author) {
	this.author=author;
}
public void setyear(String year) {
	this.year = year;
}
public String getyear() {
	return year;
}
public Topic getTopic() {
	return topic;
}
public void settopic(Topic topic) {
	this.topic=topic;
}
}
