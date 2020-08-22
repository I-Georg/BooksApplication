package com.example.demo;

import java.util.List;

public interface BookService {
List<Book> getAllBooks();
void saveBooks(Book book);
//void deleteBook(String pk);
}
