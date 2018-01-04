package com.info.model;


public class OrderModel 
{
	private String userId;
	private String name;
	private String mobile;
	private String email;
	private String address;
	private String total;
	private String id;
	public OrderModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public OrderModel(String userId, String name, String mobile, String email,
			String address, String total, String id) {
		super();
		this.userId = userId;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.total = total;
		this.id = id;
	}



	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
