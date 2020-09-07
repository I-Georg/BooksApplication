package com.example.demo.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;


@EnableWebMvc
@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	
	//get all the books
	
	 
	 @GetMapping("/book")
	    public String viewBooks(@AuthenticationPrincipal OidcUser user,Model model) {
		 model.addAttribute("listBooks", bookService.getAllBooks());
		 model.addAttribute("email",	 user.getAttributes().get("email"));
	        return "index";
	    }
	 //welcome page
	 @GetMapping("/")
	    public String welcome(@AuthenticationPrincipal OidcUser user) {
		
	        return "welcome";
	    }
	
	 //create a new entry -new book
	  @GetMapping("/new")
	    public String addUser( Model model) throws Exception {
		  try {
		  Book book = new Book();
	        model.addAttribute("book", book);
	        if(book == null) {
	        	throw new Exception("Book not found");
	        }
		  
	        return "new_book";
		  }catch (Exception e) {
				throw new Exception("Internal Server Exception while getting exception");
	    }}
	  //save the book
	  @PostMapping("/saveBook")
	    public String saveBook(Model model, Book book) {
	        // save employee to database
	        bookService.saveBooks(book);
	        model.addAttribute("book",bookService.getAllBooks());
	        return "redirect:/book";
	    }
	  
//get edit
	  @GetMapping("/edit/{id}")
	  public String showUpdateForm(@PathVariable("id") long id, Model model) {
	      Book book = bookService.findById(id)
	        .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	      
	      model.addAttribute("book", book);
	      return "update-book";
	  }
	  //update book
	  @PostMapping("/update/{id}")
	  public String updateUser(@PathVariable("id") long id,  Book book, 
	    BindingResult result, Model model) {
	      if (result.hasErrors()) {
	          book.setId(id);
	          return "update-book";
	      }
	          
	     bookService.saveBooks(book);
	      model.addAttribute("users", bookService.getAllBooks());
	      return "redirect:/book";
	  }
	  //delete book
	  @GetMapping("/delete/{id}")
	  public String deleteUser(@PathVariable("id") long id, Model model) {
	      Book book = bookService.findById(id)
	        .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	      bookService.deleteBook(id);
	      model.addAttribute("users", bookService.getAllBooks());
	      return "redirect:/book";
	  }
	  //profile
	  @GetMapping("/profile")
	    public String viewProfile(@AuthenticationPrincipal OidcUser user,Model model) {
		  model.addAttribute("name",user.getAttributes().get("name"));
		 model.addAttribute("email",user.getAttributes().get("email"));
	        return "profile";
	    }
	
	}

