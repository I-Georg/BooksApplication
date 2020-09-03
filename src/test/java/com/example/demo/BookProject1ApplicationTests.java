package com.example.demo;



import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
class BookProject1ApplicationTests {
	
	    @Autowired
	    private BookRepository repository;

	    @Test
	    public void saveBookTest() {
	      Book book = new Book();
	      repository.save(book);
	      assertEquals(book.getName(), book.getAuthor());
	       
	    }
	    @Test
	    public void deleteBookTest() {
	        Book book = new Book();
	        repository.save(book);
	        repository.deleteById(book.getId());
	    }
    }

	                
	


