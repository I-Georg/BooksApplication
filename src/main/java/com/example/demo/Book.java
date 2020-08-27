package com.example.demo;
import javax.persistence.Column;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;




@Entity
public class Book{
	@Id 
	   @GeneratedValue
		@Column(name="id",unique = true,nullable = false)
	    private Long id;
	


	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	private String name;
	private String author;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	}

