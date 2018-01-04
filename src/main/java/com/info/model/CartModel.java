package com.info.model;

public class CartModel 
{
	private String userid;
	private String itemName;
	private String price;
	
	
	
	
	public CartModel() {
		super();
		// TODO Auto-generated constructor stub
	}




	public CartModel(String userid, String itemName, String price) {
		super();
		this.userid = userid;
		this.itemName = itemName;
		this.price = price;
	}




	public String getUserid() {
		return userid;
	}




	public void setUserid(String userid) {
		this.userid = userid;
	}




	public String getItemName() {
		return itemName;
	}




	public void setItemName(String itemName) {
		this.itemName = itemName;
	}




	public String getPrice() {
		return price;
	}




	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
	
	
}
