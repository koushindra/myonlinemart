package com.info.model;

public class CustModel 
{
	private String name;
	private String mobile;
	private String email;
	
	private String location;
	
	private String username;
	private String password;
	private String id;
	public CustModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustModel(String name, String mobile, String email, String location,
			String username, String password, String id) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
