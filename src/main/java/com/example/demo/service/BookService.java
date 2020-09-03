package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Book;

public interface BookService {
List<Book> getAllBooks();
void saveBooks(Book book);
//void saveNew(KeyEntity pkbook);
void deleteBook(long id);
Optional<Book> findById(long id);
}
