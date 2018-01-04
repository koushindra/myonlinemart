package com.info.model;

import java.io.InputStream;

public class ItemModel 
{
	private String name;
	private String cat;
	private String price;
	private String pCat;
	
	
	
	private String qyt;
	private String shopno;
	private String location;
	private InputStream image;
	private String desc;
	private String id;
	public ItemModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemModel(String name, String cat, String price, String pCat,
			String qyt, String shopno, String location, InputStream image,
			String desc, String id) {
		super();
		this.name = name;
		this.cat = cat;
		this.price = price;
		this.pCat = pCat;
		this.qyt = qyt;
		this.shopno = shopno;
		this.location = location;
		this.image = image;
		this.desc = desc;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getpCat() {
		return pCat;
	}
	public void setpCat(String pCat) {
		this.pCat = pCat;
	}
	public String getQyt() {
		return qyt;
	}
	public void setQyt(String qyt) {
		this.qyt = qyt;
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
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
