package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	//get all the books
	 @GetMapping("/")
	    public String viewBooks(Model model) {
		 model.addAttribute("listBooks", bookService.getAllBooks());
	        return "index";
	    }
	 //create a new entry -new book
	  @GetMapping("/new")
	    public String addUser( Model model) {
		  Book book = new Book();
	        model.addAttribute("book", book);
	        return "new_book";
	    }
	  //save the book
	  @PostMapping("/saveBook")
	    public String saveBook(Model model, Book book) {
	        // save employee to database
	        bookService.saveBooks(book);
	        model.addAttribute("book",bookService.getAllBooks());
	        return "redirect:/";
	    }

	
	}

