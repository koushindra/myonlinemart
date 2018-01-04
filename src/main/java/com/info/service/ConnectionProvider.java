package com.info.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider 
{
	public static Connection getConnection()
	{
		Connection con=null;
		String classAddress="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/onlinemart";
		String user="root";
		String password="1234";
		
		try
		{
			Class.forName(classAddress);
			con=DriverManager.getConnection(url,user,password);
		}
		catch(Exception e)
		{
			System.out.println("Error macking connection - "+e);
		}
		
		return con;
		
	}
}
