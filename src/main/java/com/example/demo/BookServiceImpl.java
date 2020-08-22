package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BookServiceImpl implements BookService {
@Autowired
private BookRepository bookRepository;
	@Override
	public List<Book> getAllBooks() {
	
		return bookRepository.findAll();
	}

	@Override
	public void saveBooks(Book book) {
		this.bookRepository.save(book);
		
	}
/*
	@Override
	public void deleteBook(Long pk) {
		this.bookRepository.deleteById(pk);
		
	}
*/
}
