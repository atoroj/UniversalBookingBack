package com.example.demo.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.models.IBook;
import com.example.demo.services.bookService;

public class bookController {
public bookService bookservice;
	
	public bookController(bookService bookservice) {
		this.bookservice = bookservice;
	}
	
	@PostMapping("/createBook")
	public boolean createUser(@RequestBody IBook book) throws InterruptedException, ExecutionException {
		return bookService.createBook(book);
	}
}
