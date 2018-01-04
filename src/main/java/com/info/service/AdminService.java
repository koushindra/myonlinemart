package com.info.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class AdminService 
{
	public static boolean  loginValidation(String username , String password)
	{
		boolean flag=false;	
		String query="select * from admin where username=? and password=?";
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
}
