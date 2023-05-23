package com.example.demo.models;

public class IUser {
	private String name;
	private String password;
	private String email;
	private int rate;
	private int rol;
	
	public IUser() {}
	public IUser(String name, String password, String email, int rate,  int rol) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.rate = rate;
		this.rol = rol;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
}
