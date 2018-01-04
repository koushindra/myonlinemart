package com.info.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.info.model.OrderModel;
public class OrderService 
{
	public static boolean insertOrder(OrderModel model)
	{
		boolean flag=false;
		String query="insert into orderlist values(?,?,?,?,?,?,?)";
		try
		{
			Connection con= ConnectionProvider.getConnection();
			PreparedStatement ps =con.prepareStatement(query);
			ps.setString(1, model.getName());
			ps.setString(2, model.getUserId());
			ps.setString(3, model.getMobile());
			ps.setString(4, model.getEmail());
			ps.setString(5, model.getAddress());
			ps.setString(6, model.getTotal());
			ps.setString(7, model.getId());
			int rs=ps.executeUpdate();
			if(rs>0)
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
	public static ArrayList<OrderModel> getOrder()
	{
		ArrayList<OrderModel> diseaseDB = new ArrayList<OrderModel>();
		
		try
		{
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from orderlist");			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())	
			{
				
				String name=rs.getString(1);
			
				String userId=rs.getString(2);
				String mobile=rs.getString(3);
				String email=rs.getString(4);
				String address=rs.getString(5);
				String total=rs.getString(6);
				String id=rs.getString(7);
				
				OrderModel obj=new OrderModel(userId, name, mobile, email, address, total, id);
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
			PreparedStatement ps = con.prepareStatement("delete from orderlist where id=?");
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
