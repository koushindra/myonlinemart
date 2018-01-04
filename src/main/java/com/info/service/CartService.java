package com.info.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.info.model.CartModel;
public class CartService 
{
	public static boolean insertCart(String userid,String name,String price)
	{
		boolean flag=false;
		String query="insert into cart values(?,?,?)";
		try
		{
			Connection con= ConnectionProvider.getConnection();
			PreparedStatement ps =con.prepareStatement(query);
			ps.setString(1, userid);
			ps.setString(2, name);
			ps.setString(3, price);
			int rs=ps.executeUpdate();
			while(rs>0)
			{
				flag =true;
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("Validation faild---"+e);
		}
		return flag;
	}
	
	
	
	
	
	public static ArrayList<CartModel> getDises()
	{
		ArrayList<CartModel> diseaseDB = new ArrayList<CartModel>();
		
		try
		{
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from cartoption");			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())	
			{
				
				String name=rs.getString(1);
				String price=rs.getString(2);
				String userid=rs.getString(3);
				
				CartModel obj=new CartModel(userid, name, price);	
				diseaseDB.add(obj);
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception while fetchingitem : "+e);
		}		
		return diseaseDB;
	}
	
	
	
	public static boolean removeItem(String Id)
	{
		boolean flag = false;
		System.out.println("***"+Id);
		
		try
		{
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from cartoption where userId=?");
			ps.setString(1, Id);
			int rs = ps.executeUpdate();
			System.out.println("DELET SUCCESS");
			if(rs>0)
			{
				flag = true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception while dleting item type : "+e);
		}
		
		return flag;
	}
}
