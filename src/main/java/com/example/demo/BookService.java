package com.example.demo;

import java.util.List;
import java.util.Optional;

public interface BookService {
List<Book> getAllBooks();
void saveBooks(Book book);
//void saveNew(KeyEntity pkbook);
//void deleteBook(String pk);
Optional<Book> findById(long id);
}
