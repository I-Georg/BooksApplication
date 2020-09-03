package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

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

	@Override
	public Optional<Book> findById(long id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id);
	}

	@Override
	public void deleteBook(long id) {
		// TODO Auto-generated method stub
		this.bookRepository.deleteById(id);
	}

	
}
