package com.info.service;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.info.model.ItemModel;

public class ItemService 
{
	public static boolean  insertPalace(ItemModel model)
	{
		boolean flag=false;	
		try
		{
			Connection con= ConnectionProvider.getConnection();
			PreparedStatement ps =con.prepareStatement("insert into item values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, model.getName());
			ps.setString(2, model.getPrice());
			ps.setString(3, model.getpCat());
			ps.setString(4, model.getCat());
			ps.setString(5, model.getQyt());
			ps.setString(6, model.getShopno());
			ps.setString(7, model.getLocation());
			ps.setBinaryStream(8, model.getImage());
			ps.setString(9, model.getDesc());
			ps.setString(10, model.getId());
			int num = ps.executeUpdate();
			if(num>0)
			{
				flag = true;
			}
			System.out.println("inserting Succesfully....");
		}
		catch(Exception e)
		{
			System.out.println("Validation faild---"+e);
		}
		
		return flag;		
	}
	
	public static ArrayList<ItemModel> getPalace()
	{
		ArrayList<ItemModel> diseaseDB = new ArrayList<ItemModel>();
		try
		{
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from item");			
			ResultSet rs = ps.executeQuery();
			while(rs.next())	
			{
				String name=rs.getString(1);
				
				String price=rs.getString(2);
				String pCat=rs.getString(3);
				
				String cat=rs.getString(4);
				String qyt=rs.getString(5);
				
				String shopno=rs.getString(6);
				String location=rs.getString(7);
				
				InputStream image=rs.getBinaryStream(8);
				
				String desc=rs.getString(9);
				String id=rs.getString(10);
				
				ItemModel obj=new ItemModel(name, cat, price, pCat, qyt, shopno, location, image, desc, id);	
				diseaseDB.add(obj);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception while fetchingitem : "+e);
		}		
		return diseaseDB;
	}
	
	
	public static boolean removePlace(String typeId)
	{
		boolean flag = false;
		
		try
		{
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from item where id=?");
			ps.setString(1, typeId);
			int rs = ps.executeUpdate();
			System.out.println("DELET SUCCESS");
			if(rs>0)
			{
				flag = true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception while dleting sms type : "+e);
		}
		
		return flag;
	}
}
