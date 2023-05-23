package com.example.demo.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ILogin;
import com.example.demo.models.IUser;
import com.example.demo.services.userService;

@RestController
public class userController {
	public userService userservice;
	
	public userController(userService userservice) {
		this.userservice = userservice;
	}
	
	@PostMapping("/createUser")
	public boolean createUser(@RequestBody IUser user) throws InterruptedException, ExecutionException {
		return userService.createUser(user);
	}
	
	//localhost:8081/view?userName=test
	@GetMapping("/view")
	public IUser viewUser(@RequestParam String userName) throws InterruptedException, ExecutionException {
		return userService.viewUser(userName);
	}
	
	@PostMapping("/check")
	public int checkUser(@RequestBody ILogin login) throws InterruptedException, ExecutionException {
		return userService.checkLogin(login);
	}
}
