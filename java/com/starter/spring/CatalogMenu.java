package com.example.demo.Cinema.Model;
public class CatalogMenu {
private String name;
private String desc;
private int rating;
public CatalogMenu() {
	super();
	}
public CatalogMenu(String name, String desc, int rating) {
	super();
	this.name = name;
	this.desc = desc;
	this.rating = rating;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}
@Override
public String toString() {
	return "CatalogMenu [name=" + name + ", desc=" + desc + ", rating=" + rating + "]";
}
}
