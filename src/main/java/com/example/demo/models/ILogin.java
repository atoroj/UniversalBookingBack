package com.example.demo.models;

public class ILogin {
	private String password;
	private String email;
	
	public ILogin() {}
	public ILogin(String password, String email) {
		this.password = password;
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
