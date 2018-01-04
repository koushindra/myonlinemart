package com.info.model;

public class UserModel 
{
	private String name;
	private String mobile;
	
	private String shopno;
	private String location;
	
	private String username;
	private String password;
	private String id;
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserModel(String name, String mobile, String shopno,
			String location, String username, String password, String id) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.shopno = shopno;
		this.location = location;
		this.username = username;
		this.password = password;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getShopno() {
		return shopno;
	}
	public void setShopno(String shopno) {
		this.shopno = shopno;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
