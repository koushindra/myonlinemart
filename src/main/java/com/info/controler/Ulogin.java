package com.info.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.info.service.ConnectionProvider;
import com.info.service.UserService;

/**
 * Servlet implementation class Userlogin
 */
@WebServlet("/Userlogin")
public class Ulogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ulogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		String userId=null;
		String shopNo=null;
		String location=null;
		
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
				userId=rs.getString(7);
				shopNo=rs.getString(4);
				location=rs.getString(5);
			}
			System.out.println("validation Succesfully");
		}
		catch(Exception e)
		{
			System.out.println("Validation faild---"+e);
		}
		
		
		if (flag) {
			session.setAttribute("loginFlag", "true");
			session.setAttribute("userId", userId);
			session.setAttribute("shopNo", shopNo);
			session.setAttribute("location", location);
			
			RequestDispatcher rd=request.getRequestDispatcher("Welcomeuser");
			rd.forward(request, response);
		}
		
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("UserLoginPage.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
