package com.info.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.info.model.CustModel;
public class CustService 
{
	public static boolean  insertUser(CustModel model)
	{
		boolean flag=false;	
		try
		{
			Connection con= ConnectionProvider.getConnection();
			PreparedStatement ps =con.prepareStatement("insert into cust values(?,?,?,?,?,?,?)");
			ps.setString(1, model.getName());
			ps.setString(2, model.getMobile());
			ps.setString(3, model.getEmail());
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
}
