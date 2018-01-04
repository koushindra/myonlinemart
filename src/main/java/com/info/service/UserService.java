package com.info.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.info.model.UserModel;

public class UserService 
{
	
	
	
	public static boolean  loginValidation(String username , String password)
	{
		boolean flag=false;	
		String query="select * from user where username=? and password=?";
		try
		{
			Connection con= ConnectionProvider.getConnection();
			PreparedStatement ps =con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				flag=true;
			}
			System.out.println("validation Succesfully");
		}
		catch(Exception e)
		{
			System.out.println("Validation faild---"+e);
		}
		
		return flag;		
	}
	
	
	public static boolean  insertUser(UserModel model)
	{
		boolean flag=false;	
		try
		{
			Connection con= ConnectionProvider.getConnection();
			PreparedStatement ps =con.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
			ps.setString(1, model.getName());
			ps.setString(2, model.getMobile());
			
			ps.setString(3, model.getShopno());
			ps.setString(4, model.getLocation());
			
			
			
			ps.setString(5, model.getUsername());
			ps.setString(6, model.getPassword());
			ps.setString(7, model.getId());
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
	
	
	public static ArrayList<UserModel> getDemo()
	{
		ArrayList<UserModel> diseaseDB = new ArrayList<UserModel>();
		try
		{
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user");			
			ResultSet rs = ps.executeQuery();
			while(rs.next())	
			{
				String name=rs.getString(1);
				String mobile=rs.getString(2);
				String shopno=rs.getString(3);
				String location=rs.getString(4);
				String username=rs.getString(5);
				String password=rs.getString(6);
				String id=rs.getString(7);
				
				UserModel obj=new UserModel(name, mobile,shopno, location, username, password, id);	
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
			PreparedStatement ps = con.prepareStatement("delete from user where id=?");
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
