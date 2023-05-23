package com.example.demo.models;

public class IBook {
	private String sellerId;
	private String name;
	private String coords;
	
	public IBook() {}
	public IBook(String sellerId, String name, String coords) {
		super();
		this.sellerId = sellerId;
		this.name = name;
		this.coords = coords;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCoords() {
		return coords;
	}
	public void setCoords(String coords) {
		this.coords = coords;
	}
	
}
